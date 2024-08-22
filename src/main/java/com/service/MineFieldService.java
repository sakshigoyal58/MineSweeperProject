package com.service;

import java.util.Random;

import com.model.MineField;
import com.util.IInputValidator;

public class MineFieldService implements IMineFieldService {

    private IInputValidator inputValidator;
    private MineField mineField;

    public MineFieldService(IInputValidator inputValidator)
    {
        this.inputValidator = inputValidator;
    }

    
    public MineField createMineField(int size) {
        if (inputValidator.isValidGridSize(size)) {
            mineField = new MineField(size);
            return mineField;
        } else 
            throw new IllegalArgumentException("Invalid grid size! Please enter a number between 1 and 26.");
    }

   
    public void setMines(int numberOfMines)
    {
        if(inputValidator.validateNumberOfMines(numberOfMines, mineField.getRows()))
            mineField.setMines(numberOfMines);
        else
            throw new IllegalArgumentException("Mines should be max of 35% of the total squares.");      
    }

    
    public void assignMinesInGrid()
    {
        Random random = new Random();
        int placedMines = 0;

        while (placedMines < mineField.getMines()) {
            int row = random.nextInt(mineField.getRows());
            int col = random.nextInt(mineField.getColumns());
            char[][] grid = mineField.getGrid();
            if (grid[row][col] == '_') {
                grid[row][col] = '*';
                placedMines++;
            }
        }
    }

   
    public void printMineField()
    {
        int rowNumber = 65;
        char[][] grid = mineField.getGrid();

        System.out.print("  "); 
        for (int col = 1; col <= mineField.getColumns(); col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < mineField.getRows(); row++) {

            System.out.print((char) rowNumber + " ");

            for (int column = 0; column < mineField.getColumns(); column++) {
                if(grid[row][column] == '*')
                {
                    System.out.print("_ ");
                }
                else if (Character.isDigit(grid[row][column])) {
                    System.out.print(grid[row][column] + " "); 
                } else {
                    System.out.print(grid[row][column] + " "); 
                }
            }
            System.out.println();
            rowNumber++;
        }
    }
    
}
