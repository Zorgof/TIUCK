package com.company.engine;

import com.company.engine.ship.Ship;
import com.company.engine.scanner.ScannerUtil;

import java.util.List;


public class Game {

    public Game() {
        ScannerUtil scannerUtil = new ScannerUtil();
        Board board = scannerUtil.createBoard();
        List<Ship> listShips = scannerUtil.getUserShipsList();
        startGame(board, listShips);
    }


    private void startGame(Board board, List<Ship> listShips) {
        GameEngine gameEngine = new GameEngine(board, listShips);
        gameEngine.configuration();
        gameEngine.play();
    }

}
