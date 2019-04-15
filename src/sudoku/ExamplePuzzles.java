package sudoku;

import java.util.Random;

public class ExamplePuzzles {

	private static SudokuTable[] exampleTables = new SudokuTable[3];
	private static int tableNum;
	Random rnd= new Random();
	
	public SudokuTable createExamplePuzzle(){
		tableNum=rnd.nextInt(4-1);
		SudokuTable table = exampleTables[tableNum];
		return table;
	}

	public ExamplePuzzles(){
		for (int i = 0; i < exampleTables.length; i++) {
			exampleTables[i] = new SudokuTable();
		}
		exampleTables[0].getDigit(0,0).setAnswer(3);
		exampleTables[0].getDigit(3,0).setAnswer(2);
		exampleTables[0].getDigit(1,1).setAnswer(7);
		exampleTables[0].getDigit(2,1).setAnswer(2);
		exampleTables[0].getDigit(3,1).setAnswer(6);
		exampleTables[0].getDigit(5,1).setAnswer(1);
		exampleTables[0].getDigit(6,1).setAnswer(3);
		exampleTables[0].getDigit(0,2).setAnswer(5);
		exampleTables[0].getDigit(1,2).setAnswer(4);
		exampleTables[0].getDigit(7,2).setAnswer(9);
		exampleTables[0].getDigit(8,2).setAnswer(2);
		exampleTables[0].getDigit(2,3).setAnswer(3);
		exampleTables[0].getDigit(3,3).setAnswer(1);
		exampleTables[0].getDigit(4,3).setAnswer(6);
		exampleTables[0].getDigit(6,3).setAnswer(2);
		exampleTables[0].getDigit(7,3).setAnswer(8);
		exampleTables[0].getDigit(1,4).setAnswer(1);
		exampleTables[0].getDigit(4,4).setAnswer(5);
		exampleTables[0].getDigit(7,4).setAnswer(7);
		exampleTables[0].getDigit(1,5).setAnswer(9);
		exampleTables[0].getDigit(2,5).setAnswer(7);
		exampleTables[0].getDigit(4,5).setAnswer(3);
		exampleTables[0].getDigit(5,5).setAnswer(8);
		exampleTables[0].getDigit(6,5).setAnswer(5);
		exampleTables[0].getDigit(0,6).setAnswer(7);
		exampleTables[0].getDigit(1,6).setAnswer(2);
		exampleTables[0].getDigit(7,6).setAnswer(4);
		exampleTables[0].getDigit(8,6).setAnswer(8);
		exampleTables[0].getDigit(2,7).setAnswer(6);
		exampleTables[0].getDigit(3,7).setAnswer(7);
		exampleTables[0].getDigit(5,7).setAnswer(4);
		exampleTables[0].getDigit(6,7).setAnswer(1);
		exampleTables[0].getDigit(7,7).setAnswer(3);
		exampleTables[0].getDigit(5,8).setAnswer(9);
		exampleTables[0].getDigit(8,8).setAnswer(6);
		
		exampleTables[1].getDigit(6,0).setAnswer(4);
		exampleTables[1].getDigit(8,0).setAnswer(3);
		exampleTables[1].getDigit(4,1).setAnswer(1);
		exampleTables[1].getDigit(3,2).setAnswer(9);
		exampleTables[1].getDigit(5,2).setAnswer(3);
		exampleTables[1].getDigit(7,2).setAnswer(8);
		exampleTables[1].getDigit(8,2).setAnswer(1);
		exampleTables[1].getDigit(2,3).setAnswer(3);
		exampleTables[1].getDigit(4,3).setAnswer(2);
		exampleTables[1].getDigit(5,3).setAnswer(9);
		exampleTables[1].getDigit(7,3).setAnswer(7);
		exampleTables[1].getDigit(8,3).setAnswer(5);
		exampleTables[1].getDigit(2,4).setAnswer(8);
		exampleTables[1].getDigit(3,4).setAnswer(7);
		exampleTables[1].getDigit(5,4).setAnswer(5);
		exampleTables[1].getDigit(6,4).setAnswer(1);
		exampleTables[1].getDigit(0,5).setAnswer(5);
		exampleTables[1].getDigit(1,5).setAnswer(9);
		exampleTables[1].getDigit(3,5).setAnswer(1);
		exampleTables[1].getDigit(4,5).setAnswer(4);
		exampleTables[1].getDigit(6,5).setAnswer(2);
		exampleTables[1].getDigit(0,6).setAnswer(7);
		exampleTables[1].getDigit(1,6).setAnswer(8);
		exampleTables[1].getDigit(3,6).setAnswer(2);
		exampleTables[1].getDigit(5,6).setAnswer(6);
		exampleTables[1].getDigit(4,7).setAnswer(9);
		exampleTables[1].getDigit(0,8).setAnswer(6);
		exampleTables[1].getDigit(2,8).setAnswer(1);

		exampleTables[2].getDigit(0,0).setAnswer(1);
		exampleTables[2].getDigit(0,1).setAnswer(2);
		exampleTables[2].getDigit(0,2).setAnswer(3);
		exampleTables[2].getDigit(0,3).setAnswer(4);
		exampleTables[2].getDigit(0,4).setAnswer(5);
		exampleTables[2].getDigit(0,5).setAnswer(6);
		exampleTables[2].getDigit(0,6).setAnswer(7);
		exampleTables[2].getDigit(0,7).setAnswer(8);
		exampleTables[2].getDigit(0,8).setAnswer(9);
		exampleTables[2].getDigit(1,0).setAnswer(4);
		exampleTables[2].getDigit(1,1).setAnswer(5);
		exampleTables[2].getDigit(1,2).setAnswer(6);
		exampleTables[2].getDigit(1,3).setAnswer(7);
		exampleTables[2].getDigit(1,4).setAnswer(8);
		exampleTables[2].getDigit(1,5).setAnswer(9);
	}

}