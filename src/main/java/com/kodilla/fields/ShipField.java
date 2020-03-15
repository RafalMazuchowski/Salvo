package com.kodilla.fields;

public class ShipField extends Field {
    public short shipSize;
    private boolean hit;
    private boolean sunk;

    //functionality preparation for implementation in next version
    public short getShipSize() {
        return shipSize;
    }

    public void setShipSize(short shipSize) {
        this.shipSize = shipSize;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    //functionality preparation for implementation in next version
    public boolean isSunk() {
        return sunk;
    }

    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    @Override
    public boolean emptyField() {
        return false;
    }
}
