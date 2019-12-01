package com.company.engine;

import com.company.engine.scanner.ScannerUtil;
import com.company.engine.ship.Ship;
import com.company.engine.ui.BoardUI;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

class GameEngine {
    private final BoardUI boardUi = new BoardUI();
    private final Board board;
    private final List<Ship> listShips;
    private int shotCounter;

    GameEngine(Board board, List<Ship> listShips) {
        this.board = board;
        this.listShips = listShips;
    }

    void configuration() {
        addShipToBoard();
    }

    private void addShipToBoard() {
        for (int shipId = 0; shipId < listShips.size(); shipId++) {
            int randomNum = getRandomNum(shipId);
            for (int filedId = 0; filedId < listShips.get(shipId).getShortPoints().size(); filedId++) {
                board.getPointList().get(randomNum + filedId).setPointShip(new PointShip(shipId, filedId));
            }
        }
    }

    private int getRandomNum(int shipId) {
        return ThreadLocalRandom
                .current()
                .nextInt(0, getMaxRandomValue(shipId));
    }

    private int getMaxRandomValue(int shipId) {
        return board.getPointList().size() + 1 - listShips.get(shipId).getShortPoints().size();
    }

    private void shotToShip(int x, int y) {
        board.getPointList()
                .stream()
                .filter(point -> point.getX() == x && point.getY() == y).collect(Collectors.toList())
                .get(0)
                .shot();

    }

    void play() {
        boardUi.show(board);
        do {
            int x = ScannerUtil.getShotFromUser(board.getBoardSize());
            int y = ScannerUtil.getShotFromUser(board.getBoardSize());

            if (isPointShoted(x, y)) {
                System.out.println("Punkt by juz ustrzelony");
            } else {
                shotToShip(x, y);
                addToResult(getShotedItem(x, y));
                boardUi.show(board);
                boardUi.showStats(listShips);
            }

            shotCounter++;

        } while (!isAllShipDestroyed());

        System.out.println("Aby wygrać potrzebowałeś: " + shotCounter);
    }

    private boolean isAllShipDestroyed() {
        return listShips.stream().allMatch(Ship::isDestroyed);
    }

    private boolean isPointShoted(int x, int y) {
       return board.getPointList()
                .stream()
                .filter(point -> point.getX() == x && point.getY() == y)
                .allMatch(Point::isShoted);
    }

    private void addToResult(PointShip shotedItem) {
        Optional.ofNullable(shotedItem)
                .ifPresent(item ->
                listShips.get(item.getShipId())
                        .getShortPoints()
                        .set(item.getFiledId(), 1));
    }

    private PointShip getShotedItem(int x, int y) {
        return board.getPointList()
                .stream()
                .filter(point -> point.getX() == x && point.getY() == y).collect(Collectors.toList())
                .get(0)
                .getPointShip();
    }

}
