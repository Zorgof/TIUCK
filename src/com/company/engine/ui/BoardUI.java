package com.company.engine.ui;

import com.company.engine.Board;
import com.company.engine.Point;
import com.company.engine.ship.Ship;

import java.util.List;

public class BoardUI {

    public void showStats(List<Ship> listShips) {
        listShips.forEach(System.out::println);
    }

    public void show(Board board) {
        List<Point> pointList = board.getPointList();
        int max = pointList.stream().map(Point::getY).mapToInt(Integer::intValue).max().getAsInt();

        for (int i = 0; i <= max; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (Point point : pointList) {
            if (point.getY() != max) {
                System.out.print(" " + point.getDescription() + " ");
            } else {
                System.out.println(" " + point.getDescription() + "   "+ point.getX()) ;
            }
        }
    }
}

