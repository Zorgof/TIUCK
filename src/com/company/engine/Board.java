package com.company.engine;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Point> pointList = new ArrayList<>();

    public Board(int size) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                pointList.add(new Point(x,y));
            }
        }
    }

    public List<Point> getPointList() {
        return pointList;
    }


}
