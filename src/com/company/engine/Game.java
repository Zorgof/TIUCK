package com.company.engine;

import com.company.engine.ship.Ship;
import com.company.engine.scanner.ScannerUtil;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private ScannerUtil scannerUtil = new ScannerUtil();
    private List<Ship> shipList = new ArrayList<>();
    private List<Ship> listShips;

    public Game() {
        Board board = scannerUtil.createBoard();
        listShips = scannerUtil.getUserShipsList();
        startGame(board, listShips);
    }


    private void startGame(Board board, List<Ship> listShips) {
        GameEngine gameEngine = new GameEngine(board, listShips);
        gameEngine.configuration();
    }

}
