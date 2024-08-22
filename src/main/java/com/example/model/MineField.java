package com.example.model;

public class MineField {

    private int rows; 
    private int columns;
    private char[][] grid;
    private int mines;

    public MineField(int size)
    {
        this.rows = size;
        this.columns = size;

        grid = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = '_';
            }
        }
    }

    public int getRows() {
        return rows;        
    }

    public int getColumns() {
        return columns;        
    }

    public char[][] getGrid(){
        return grid;
    }

    public void setMines(int numberOfMines)
    {
        mines = numberOfMines;
    }

    public int getMines()
    {
        return mines;
    }
    
}
