package com.kodilla.fields;

public abstract class Field {
    int idX;
    int idY;

    public int getIdX() {
        return idX;
    }

    public int getIdY() {
        return idY;
    }

    //functionality preparation for implementation in next version
    public abstract boolean emptyField();

}