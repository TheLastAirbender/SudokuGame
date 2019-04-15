package sudoku;

import java.util.ArrayList;

public class SudokuTable {
	int i=0;

	private SudokuDigit[][] table = new SudokuDigit[9][9];

	public SudokuTable(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				table[x][y] = new SudokuDigit(x,y);
			}
		}
	}

	

	//get a digit in the table

	public SudokuDigit getDigit(int x, int y){
		//System.out.println("getDigit");
		if (x >= 0 && x <= 8 && y >= 0 && y <= 8)
			return table[x][y];
		else
			throw new IndexOutOfBoundsException("Table x and y values are integers from 0 to 8");
	}

	boolean checkDigit(SudokuDigit digit) {
		System.out.println("Check digit");
		if (!digit.isSolved())
			return true; // возвращает истину, если не решено
		//проверяем, нет ли в строке такого числа
		for (int x = 0; x < 9; x++)
			if (digit.getAnswer() == table[x][digit.getY()].getAnswer())
				return false;
		//проверяем столбец
		for (int y = 0; y < 9; y++) 
			if (digit.getAnswer() == table[digit.getX()][y].getAnswer())
				return false;
		//проверяем квадрат
		int startPosX = (digit.getX()/3)*3;
		int startPosY = (digit.getY()/3)*3;
		for (int y = startPosY; y < startPosY + 3; y++){
			for (int x = startPosX; x < startPosX + 3; x++){
				if (digit.getAnswer() == table[x][y].getAnswer())
					return false;
			}
		}
		return true;
	}
	
	boolean solve(int position) {
		System.out.println("solve starts");
		for (position=1; position<81; position++) {
			int x = (position-1)%9;
			int y = (position-1)/9;
			SudokuDigit digit = new SudokuDigit(table[x][y]); //делаем копию значения по координатам x,y 
			
			if (table[x][y].isSolved()) {
				System.out.println("solved");
				continue;
			}
			
			System.out.println("pos"+position);
			int possible=0;
			int finalValue=0;

			for (int i=1; i<10; i++) {
				digit.setAnswer(i);
				if (checkDigit(digit)) {
					possible++;
					finalValue=i;
				}
			}
			System.out.println(possible);
			if (possible<2 && possible>0) {
				digit.setAnswer(finalValue);
				table[x][y]=digit;
				return true;
			} 
			
		}
		return false;
	}

}