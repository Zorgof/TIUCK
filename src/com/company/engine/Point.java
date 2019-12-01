package com.company.engine;


public class Point {

    private int x;
    private int y;
    private PointShip pointShip = null;
    private boolean isShoted = false;


    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PointShip getPointShip() {
        return pointShip;
    }

    public void setPointShip(PointShip pointShip) {
        this.pointShip = pointShip;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDescription() {
        return isShoted ? pointShip == null ? ShipStatus.MISSED.toString() : ShipStatus.HIT.toString()
                : ShipStatus.UNDISCOVERED.toString();
    }

    void shot(){
        isShoted = true;
    }

}
