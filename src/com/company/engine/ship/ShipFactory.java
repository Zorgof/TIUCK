package com.company.engine.ship;

public class ShipFactory {

    public ShipFactory() {
    }

    public Ship generateShip(int shipNumber) {

        switch (shipNumber) {
            case 0:
                return new ShipOne();
            case 1:
                return new ShipTwo();
            case 2:
                return new ShipThree();
            default:
                throw new IllegalArgumentException(" Unknown number");
        }
    }
}
