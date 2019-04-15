package sudoku;

import java.util.ArrayList;

public class SudokuDigit {
	private int answer;
	private int xLocation;
	private int yLocation;
	private ArrayList<Integer> possibleValues = new ArrayList<Integer>();
	private boolean isSafe = false;

//конструктор с уже известным ответом
	SudokuDigit(int answer){
		this.answer = answer;
	}

//конструктор с неизвестным ответом, устанавливает значения возможных решений от 1 до 9
	SudokuDigit(int xLocation, int yLocation){
		for (int i = 0; i < 9; i++){
			possibleValues.add(i+1);
		}
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}

//copy constructor
	SudokuDigit(SudokuDigit sudokuDigit){
		this.answer = sudokuDigit.answer;
		this.xLocation = sudokuDigit.xLocation;
		this.yLocation = sudokuDigit.yLocation;
		this.possibleValues = sudokuDigit.possibleValues;
		this.isSafe = sudokuDigit.isSafe;
	}

//---
	public ArrayList<Integer> getPossibleValues(){
		return possibleValues;
	}

	public boolean isSolved(){
		return (answer != 0);
	}

	public int getAnswer(){
		return answer;
	}

	public int getX(){
		return xLocation;
	}

	public int getY(){
		return yLocation;
	}

//устанавливает значение конечного ответа, убирает остальные возможные значения
	public void setAnswer(int answer){
		this.answer = answer;
		possibleValues.clear();
		if (answer == 0) { // если 0, то добавляет все возможные значения
			for (int i = 1; i < 10; i ++)
				this.possibleValues.add(i);
		}
	}

}