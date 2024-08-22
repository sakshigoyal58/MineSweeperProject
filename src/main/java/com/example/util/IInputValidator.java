package com.example.util;

public interface IInputValidator {

    boolean isValidGridSize(int size);

    boolean validateNumberOfMines(int numberOfMines, int size);

}