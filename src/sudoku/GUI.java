package sudoku;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	private SudokuTable sudokuTable = new SudokuTable();
	private JFrame frame = new JFrame("Sudoku Solver");
	private JTextField textField[][] = new JTextField[9][9];
	private GridPanel gridPanel = new GridPanel(new GridLayout(9,9,1,1));

// � ������������ ��������� TextField �� gridPanel
	GUI(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				textField[x][y] = new JTextField();
				textField[x][y].setForeground(Color.RED);
				gridPanel.add(textField[x][y]);
			}
		}
	}

//�������� �� ������������ ��������� �������� (���� �� �������� �����, �� ����� ������)	
	boolean checkText(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				if (!textField[x][y].getText().equals("")){
					try {
						int digit = Integer.parseInt(textField[x][y].getText());
						if (digit <= 0 || digit >= 10)
							return false;
					}
					catch (NumberFormatException e){
						return false;
					}
				}
			}
		}
		return true;
	}

//������� �������� � ����� � ����� SudokuTable 	
	public void GUIToSudokuTable(){
		System.out.println("GUItoSudokuTable Start");
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				if (!textField[x][y].getText().equals("")){
					//System.out.println("if starts");
					sudokuTable.getDigit(x,y).setAnswer(Integer.parseInt(textField[x][y].getText())); 
					//sudokuTable.getDigit(x,y).setSafe(true);
					textField[x][y].setForeground(Color.RED);
				}
				else {
					//System.out.println("else Starts");
					sudokuTable.getDigit(x,y).setAnswer(0); //clear any blank table digits by setting them to 0
					textField[x][y].setForeground(Color.BLACK); //colour blanks to black
				}
			}
		}
	}

//������� �������� �� SudokuTable �� �����	
	public void sudokuTableToGUI(){
		System.out.println("sudokuTabletoGUI starts");
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){		
				if (sudokuTable.getDigit(x,y).isSolved())
					textField[x][y].setText(String.valueOf(sudokuTable.getDigit(x,y).getAnswer()));			
			}
		}
	}

//�������� ��� ������ �� �����	
	public void clearGrid(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				textField[x][y].setText("");
	textField[x][y].setForeground(Color.RED);
			}
		}
	}

	public void createGUI(){
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.weighty = 1;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;

		JLabel topLabel = new JLabel("������� ������", JLabel.CENTER);
		topLabel.setBackground(Color.WHITE);
		topLabel.setForeground(Color.BLACK);
		topLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		mainPanel.add(topLabel, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		mainPanel.add(gridPanel, gridBagConstraints); 

		gridBagConstraints.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints.weighty = 0.1;

		JButton exampleButton = new JButton("������� �������");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.anchor = GridBagConstraints.SOUTH;
		mainPanel.add(exampleButton, gridBagConstraints);

		exampleButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				ExamplePuzzles example = new ExamplePuzzles();
				sudokuTable = example.createExamplePuzzle();
				clearGrid();
				sudokuTableToGUI();
			}
		});

		JButton clearButton = new JButton("��������");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		mainPanel.add(clearButton, gridBagConstraints);
		
		clearButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				sudokuTable = new SudokuTable();
				clearGrid();
			}
		});

		JButton solveButton = new JButton("������");
		System.out.println("GUI Start");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		mainPanel.add(solveButton, gridBagConstraints);

		solveButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				//System.out.println("Solve Pressed");
				if (!checkText())
					JOptionPane.showMessageDialog(frame,"�������� ������ ���� �� 1 �� 9","������",JOptionPane.ERROR_MESSAGE);
				else {
					GUIToSudokuTable();
					//System.out.println("GUItoSudokuTable ends");
					if (!sudokuTable.solve(1))
						JOptionPane.showMessageDialog(frame,"���������� ������","������",JOptionPane.ERROR_MESSAGE);
					else
						sudokuTableToGUI();
				}
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().add(mainPanel); 
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(500,500));
		frame.setVisible(true);
	}

//-------------------------------------------	
	public class GridPanel extends JPanel{

		GridPanel(GridLayout layout){
			super(layout);
		}

		public void paintComponent(Graphics g){
			g.fillRect(getWidth()/3 - 1,0,3,getHeight());
			g.fillRect(2*getWidth()/3 - 1,0,3,getHeight());
			g.fillRect(0,getHeight()/3 - 1,getWidth(),3);
			g.fillRect(0,2*getHeight()/3 - 2,getWidth(),3);
		}
	}

}