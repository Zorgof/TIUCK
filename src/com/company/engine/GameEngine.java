package com.company.engine;

import com.company.engine.ship.Ship;
import com.company.engine.ui.BoardUI;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

class GameEngine {
    private BoardUI boardUi = new BoardUI();
    private Board board;
    private List<Ship> listShips;
    private int shotCounter;

    GameEngine(Board board, List<Ship> listShips) {
        this.board = board;
        this.listShips = listShips;
    }

    void configuration() {
        addShipToBoard();
        play();
    }

    private void addShipToBoard() {
        for (int shipId = 0; shipId < listShips.size(); shipId++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, board.getPointList().size() + 1 - listShips.get(shipId).getShortPoints().size());
            for (int filedId = 0; filedId < listShips.get(shipId).getShortPoints().size(); filedId++) {
                board.getPointList().get(randomNum + filedId).setPointShip(new PointShip(shipId, filedId));
            }
        }
    }

    private void shot(int x, int y) {
        board.getPointList()
                .stream()
                .filter(point -> point.getX() == x && point.getY() == y).collect(Collectors.toList())
                .get(0).shot();

    }

    private void play() {
        boardUi.show(board);

        do {
            //dodac ograniczenie do pol
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            shot(x, y);
            addToResult(getShotedItem(x, y));
            boardUi.show(board);
            boardUi.showStats(listShips);
            shotCounter++;

        } while (!listShips.stream().allMatch(Ship::isSuccess));

        System.out.println("Aby wygrać potrzebowałeś: " + shotCounter);
    }

    private void addToResult(PointShip shotedItem) {
        Optional.ofNullable(shotedItem).ifPresent(item ->
                listShips.get(item.getShipId()).getShortPoints()
                        .set(item.getFiledId(), 1));
    }

    private PointShip getShotedItem(int x, int y) {
        // dodac sprawdzenie czy byl juz klikniety item
        return board.getPointList()
                .stream()
                .filter(point -> point.getX() == x && point.getY() == y).collect(Collectors.toList())
                .get(0).getPointShip();
    }

}
