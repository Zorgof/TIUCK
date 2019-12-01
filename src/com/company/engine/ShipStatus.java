package com.company.engine;

public enum  ShipStatus {

    HIT("X"),
    MISSED("O"),
    UNDISCOVERED("*");

    private final String name;

    private ShipStatus(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
