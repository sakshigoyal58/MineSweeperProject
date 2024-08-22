package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MineFieldTest {

    private MineField mineField;

    @BeforeEach
    void setUp() {
        mineField = new MineField(5);
    }

    @Test
    void testConstructor() {
        assertEquals(5, mineField.getRows());
        assertEquals(5, mineField.getColumns());

        char[][] grid = mineField.getGrid();
        for (int row = 0; row < mineField.getRows(); row++) {
            for (int column = 0; column < mineField.getColumns(); column++) {
                assertEquals('_', grid[row][column]);
            }
        }
    }

    @Test
    void testSetMines() {
        mineField.setMines(10);
        assertEquals(10, mineField.getMines());
    }

    @Test
    void testGetGrid() {
        char[][] grid = mineField.getGrid();
        assertNotNull(grid);
    }

    
}
