package com.kodilla.fields;

import jdk.nashorn.internal.ir.annotations.Ignore;

@Ignore
public enum ShipSize {

    ONECELLSHIP (1),
    TWOCELLSHIP (2),
    THREECELLSHIP (3),
    FOURCELLSHIP (4),
    FIVECELLSHIP (5),
    SIXCELLSHIP (6);

    private int size;

    ShipSize(int size) {
        this.size = size;
    }

    public int getSizeUnit() {
        return size;
    }
}
