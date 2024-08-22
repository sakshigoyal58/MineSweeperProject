package com.example.service;

import com.example.model.MineField;

public interface IMineFieldService {
    MineField createMineField(int size);
    void setMines(int numberOfMines);
    void assignMinesInGrid();
    void printMineField();
}
