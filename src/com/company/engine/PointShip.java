package com.company.engine;

public class PointShip {

    private int shipId;
    private int filedId;
    private boolean isShoted = false;

    public PointShip(int shipId, int filedId) {
        this.shipId = shipId;
        this.filedId = filedId;
    }

    public int getShipId() {
        return shipId;
    }

    public int getFiledId() {
        return filedId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public boolean isShoted() {
        return isShoted;
    }

    public void setShoted(boolean shoted) {
        isShoted = shoted;
    }
}
