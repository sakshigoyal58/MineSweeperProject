package com.service;

import java.util.Scanner;

import com.model.MineField;

public class GameService implements IGameService{

    private MineField mineField;
    private Scanner scanner = new Scanner(System.in);
    private IMineFieldService mineFieldService ;
    private int selectedRow;
    private int selectedColumn;
    private int numberOfSquareLeft;
    

    public GameService(IMineFieldService mineFieldService)
    {
        this.mineFieldService = mineFieldService;
    }

    
    public void startGame()
    {
        System.out.println("Enter the size of the grid (e.g. 4 for a 4x4 grid): ");
        int inputSize = scanner.nextInt();
        numberOfSquareLeft = inputSize *inputSize;
        mineField = mineFieldService.createMineField(inputSize);

        System.out.println("Enter the number of mines to place on the grid (maximum is 35% of the total squares): ");
        int numberOfMines = scanner.nextInt();
        mineFieldService.setMines(numberOfMines);

        mineFieldService.assignMinesInGrid();
        mineFieldService.printMineField();

        System.out.println("Select a square to reveal (e.g. A1): ");
        String coordinate = scanner.next();
        setSelectedRowColumn(coordinate);

        char[][] grid = mineField.getGrid();

         while(playGame(selectedRow, selectedColumn, grid))
         {
            mineFieldService.printMineField();

            if(numberOfSquareLeft == numberOfMines)
            {
                System.out.println("Congratulations, you have won the game!");
                System.out.println("Press any key to play again...");
                scanner.close();
            }
            else{
                System.out.println("Select a square to reveal (e.g. A1): ");
                String value = scanner.next();
                setSelectedRowColumn(value);
            }
            
         }
        
            System.out.println("Oh no, you detonated a mine! Game over.");
            System.out.println("Press any key to play again...");
    
        scanner.close();
    }

    public void setSelectedRowColumn(String coordinate)
    {
        char rowLetter = coordinate.charAt(0);
        String columnString = coordinate.substring(1);

        if (rowLetter < 'A' || rowLetter > 'Z') {
            throw new IllegalArgumentException("Row letter must be between A and Z");
        }

        int column;
        try {
            column = Integer.parseInt(columnString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Column number must be a valid integer");
        }

        if (column < 1 || column > 26) {
            throw new IllegalArgumentException("Column number must be between 1 and 26");
        }

        selectedRow = rowLetter - 'A';
        selectedColumn = column - 1;
    }

    public boolean playGame(int row, int column, char[][] grid)
    {
        if ((row < 0 || row >= mineField.getRows()) || (column < 0 || column >= mineField.getColumns())) {
            return true;
        }

        if(isSquareContainsMine(row, column, grid) == 1)
            return false;

            if (grid[row][column] != '_') {
                return true;
            }

         
        int numberOfAdjacentMines = isSquareContainsMine(row, column +1, grid)
                                            + isSquareContainsMine(row, column-1, grid) 
                                            + isSquareContainsMine(row+1, column, grid) 
                                            + isSquareContainsMine(row-1, column, grid) 
                                            + isSquareContainsMine(row+1, column+1, grid) 
                                            + isSquareContainsMine(row+1, column-1, grid)
                                            + isSquareContainsMine(row-1, column-1, grid)
                                            + isSquareContainsMine(row-1, column+1, grid) ;
          
        grid[row][column] = (numberOfAdjacentMines > 0) ? (char)(numberOfAdjacentMines + '0') : '0';   
                              
         numberOfSquareLeft--;

        if(numberOfAdjacentMines != 0)
        {
             return true;
        }
        
        playGame(row, column-1, grid);
        playGame(row, column+1, grid);
        playGame(row+1, column, grid);
        playGame(row-1, column, grid);
        playGame(row+1, column+1, grid);
        playGame(row-1, column-1, grid);
        playGame(row+1, column-1, grid);
        playGame(row-1, column+1, grid);

        return true;
    }

    private int isSquareContainsMine(int row, int column, char[][] grid)
    {
        if(row >=0 && row < mineField.getRows() && column >=0 && column < mineField.getColumns())
        {
            return grid[row][column] == '*' ? 1 : 0;
        }
            
        return 0;
    }
    
}
