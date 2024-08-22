package com.example;

import com.example.service.GameService;
import com.example.service.IGameService;
import com.example.service.IMineFieldService;
import com.example.service.MineFieldService;
import com.example.util.IInputValidator;
import com.example.util.InputValidator;

public class App 
{
    public static void main( String[] args )
    {
        IInputValidator inputValidator = new InputValidator();
        IMineFieldService mineFieldService = new MineFieldService(inputValidator);
        IGameService gameService = new GameService(mineFieldService);
        gameService.startGame();
    } 
}
