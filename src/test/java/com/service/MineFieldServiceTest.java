package com.service;

import com.model.MineField;
import com.service.MineFieldService;
import com.util.IInputValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class MineFieldServiceTest {

    private IInputValidator inputValidator;
    private MineFieldService mineFieldService;
    private MineField mineField;

    @BeforeEach
    void setUp() {
        inputValidator = mock(IInputValidator.class);
        mineField = mock(MineField.class);
        mineFieldService = new MineFieldService(inputValidator);
    }


    @Test
    void testCreateMineFieldValidSize() {
        when(inputValidator.isValidGridSize(10)).thenReturn(true);
        MineField mineField = mineFieldService.createMineField(10);
        assertNotNull(mineField);
        assertEquals(10, mineField.getRows());
        assertEquals(10, mineField.getColumns());
    }


   /*  @Test
    void testCreateMineFieldInvalidSize() {
        when(inputValidator.isValidGridSize(27)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mineFieldService.createMineField(27);
        });
        assertEquals("Invalid grid size! Please enter a number between 1 and 26.", exception.getMessage());
    } */

    @Test
    void testSetMinesValidNumber() {
        when(inputValidator.isValidGridSize(4)).thenReturn(true);
        when(inputValidator.validateNumberOfMines(3, 4)).thenReturn(true);
        when(mineField.getRows()).thenReturn(4);
        MineField mineField  = mineFieldService.createMineField(4);
        mineFieldService.setMines(3);
        assertEquals(3, mineField.getMines());
    }

   /*  @Test
    void testSetMinesInvalidNumber() {
        when(inputValidator.validateNumberOfMines(40, 10)).thenReturn(false);
        mineFieldService.createMineField(10);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mineFieldService.setMines(40);
        });
        assertEquals("Mines should be max of 35% of the total squares.", exception.getMessage());
    } */

    @Test
    void testAssignMinesInGrid() {
        when(inputValidator.isValidGridSize(4)).thenReturn(true);
        when(inputValidator.validateNumberOfMines(3, 4)).thenReturn(true);
        when(mineField.getRows()).thenReturn(4);
        MineField mineField = mineFieldService.createMineField(4);
        mineFieldService.setMines(3);
        mineFieldService.assignMinesInGrid();

        char[][] grid = mineField.getGrid();
        int mineCount = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == '*') {
                    mineCount++;
                }
            }
        }

        assertEquals(3, mineCount);
    }

    @Test
    void testPrintMineField() {
        when(inputValidator.isValidGridSize(4)).thenReturn(true);
        when(inputValidator.validateNumberOfMines(3, 4)).thenReturn(true);
        when(mineField.getRows()).thenReturn(4);
        mineFieldService.createMineField(4);
        mineFieldService.setMines(3);
        mineFieldService.assignMinesInGrid();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        mineFieldService.printMineField();
        System.setOut(originalOut);

        String output = outputStream.toString();

        String expectedOutput = "  1 2 3 4 \n" +
                                "A _ _ _ _ \n" +
                                "B _ _ _ _ \n" +
                                "C _ _ _ _ \n" +
                                "D _ _ _ _ \n"; 

        assertEquals(expectedOutput, output);
    }
}

