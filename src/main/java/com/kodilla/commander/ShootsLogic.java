package com.kodilla.commander;

import com.kodilla.fields.Field;
import com.kodilla.fields.ShipField;
import com.kodilla.fields.ShootField;

public class ShootsLogic {
    public Field[][] shootValidator (Field[][] tempBoard, Field move){
        ShootField shoot = new ShootField();
        int x = move.getIdX() - 1;
        int y = move.getIdY() - 1;

        if (tempBoard[x][y] == null){
            shoot.setHit(false);
            tempBoard[x][y] = shoot;
        } else {
            if (tempBoard[x][y] instanceof ShipField){
                shoot.setHit(true);
                tempBoard[x][y] = new ShipField();
            } else if (tempBoard[x][y] instanceof ShootField){
                shoot.setHit(false);
            }
        }
        return tempBoard;
    }
}
