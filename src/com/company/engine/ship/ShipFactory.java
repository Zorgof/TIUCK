package com.company.engine.ship;

public class ShipFactory {

    public ShipFactory() {
    }

    public Ship generateShip(int shipNumber) {

        switch (shipNumber) {
            case 0:
                return new ShipOne("ShipOne", 1);
            case 1:
                return new ShipTwo("ShipTwo", 2);
            case 2:
                return new ShipThree("ShipThree", 3);
            default:
                throw new IllegalArgumentException(" Unknown number");
        }
    }
}
