package com.util;


public class InputValidator implements IInputValidator{

    public final int MIN_GRID_SIZE = 1;
    public final int MAX_GRID_SIZE = 26;
    public final int MIN_NUMBER_OF_MINES = 1;
    public final double TOTAL_SQUARES_PERCENTAGE = 0.35;

   
    public boolean isValidGridSize(int size) {
        return size >= MIN_GRID_SIZE && size <= MAX_GRID_SIZE;
    }
  
    public boolean validateNumberOfMines(int numberOfMines, int size){
        return  numberOfMines >= MIN_NUMBER_OF_MINES  && numberOfMines <= size * size * TOTAL_SQUARES_PERCENTAGE;
    }
}
