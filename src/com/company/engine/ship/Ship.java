package com.company.engine.ship;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {

    private int lenght;
    private List<Integer> shortPoints = new ArrayList<>();
    private String description;

    Ship(String description, int length) {
        this.description = description;
        this.lenght = length;

        for (int i = 0; i < length; i++) {
            shortPoints.add(0);
        }
    }

    public int getLenght() {
        return lenght;
    }

    public List<Integer> getShortPoints() {
        return shortPoints;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSuccess(){
        return shortPoints.stream().allMatch(item -> item.equals(1));
    }

    @Override
    public String toString() {
        return description +"{" +
                ", shortPoints=" + shortPoints +
                ", lenght=" + lenght +
                '}';
    }
}
