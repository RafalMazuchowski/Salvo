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

    public abstract boolean emptyField ();
}
// Board zawiera pola klasy Field, które będą rozszerzane