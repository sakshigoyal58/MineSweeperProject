package com.service;

import com.model.MineField;

public interface IMineFieldService {
    MineField createMineField(int size);
    void setMines(int numberOfMines);
    void assignMinesInGrid();
    void printMineField();
}
