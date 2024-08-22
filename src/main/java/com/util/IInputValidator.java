package com.util;

public interface IInputValidator {

    boolean isValidGridSize(int size);

    boolean validateNumberOfMines(int numberOfMines, int size);

}