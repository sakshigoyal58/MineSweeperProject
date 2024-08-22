
package com.util;

import org.junit.jupiter.api.Test;

import com.util.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void testIsValidGridSize() {
        assertTrue(inputValidator.isValidGridSize(1));
        assertTrue(inputValidator.isValidGridSize(10));
        assertTrue(inputValidator.isValidGridSize(26));
        assertFalse(inputValidator.isValidGridSize(0));
        assertFalse(inputValidator.isValidGridSize(27));
    }

    @Test
    void testValidateNumberOfMines() {
        assertTrue(inputValidator.validateNumberOfMines(1, 5));
        assertTrue(inputValidator.validateNumberOfMines(8, 5));
        assertFalse(inputValidator.validateNumberOfMines(0, 5));
        assertFalse(inputValidator.validateNumberOfMines(10, 5));
    }
}
