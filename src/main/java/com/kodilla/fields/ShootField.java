package com.kodilla.fields;

public class ShootField extends Field {
    boolean hit;

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public boolean emptyField() {
        return false;
    }

    // niezależny strzał / coordynaty wykonywane na zmianę przez gracza i komputer
}
