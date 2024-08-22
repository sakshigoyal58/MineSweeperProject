package com;

import com.service.GameService;
import com.service.IGameService;
import com.service.IMineFieldService;
import com.service.MineFieldService;
import com.util.IInputValidator;
import com.util.InputValidator;

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
