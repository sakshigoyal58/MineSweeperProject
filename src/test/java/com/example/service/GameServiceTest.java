package com.example.service;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.example.model.MineField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameServiceTest {

    private GameService gameService;
    private IMineFieldService mineFieldService;

    @BeforeEach
    public void setUp() {
        mineFieldService = Mockito.mock(IMineFieldService.class);
        gameService = new GameService(mineFieldService);
    }

    @Test
    void testStartGame_ValidInput() {
    
        String input = "4\n" + "5\n" + "A1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        MineField mineField = mock(MineField.class);
        when(mineFieldService.createMineField(4)).thenReturn(mineField);
        when(mineField.getRows()).thenReturn(4);
        when(mineField.getColumns()).thenReturn(4);
        when(mineField.getGrid()).thenReturn(new char[4][4]);

     
        doNothing().when(mineFieldService).setMines(5);
        doNothing().when(mineFieldService).assignMinesInGrid();

        
        gameService.startGame();

      
        verify(mineFieldService).createMineField(4);
        verify(mineFieldService).setMines(5);
        verify(mineFieldService).assignMinesInGrid();
    }


   /*  @Test
    public void testStartGameWithInvalidGridSize() {
        // Mock invalid grid size exception
        when(mineFieldService.createMineField(27)).thenThrow(new IllegalArgumentException("Invalid grid size! Please enter a number between 1 and 26."));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gameService.startGame();
        });

        assertEquals("Invalid grid size! Please enter a number between 1 and 26.", exception.getMessage());
    } */

   /*  @Test
    public void testSetSelectedRowColumnInvalidRow() {
        // Testing invalid row input
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.setSelectedRowColumn("Z1");
        });
    }

    @Test
    public void testSetSelectedRowColumnInvalidColumn() {
        // Testing invalid column input
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.setSelectedRowColumn("A27");
        });
    } */

}
