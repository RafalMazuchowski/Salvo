package com.kodilla.container;

import com.kodilla.commander.ShootsLogic;
import com.kodilla.fields.Field;
import com.kodilla.fields.ShipField;

import javax.swing.plaf.PanelUI;

public class BoardContainer {
    private int horizontal = 10;
    private int vertical = 10;
    private Field[][] playerBoard = new Field[10][10];
    private Field[][] computerBoard;

    public BoardContainer() {
    }

    public Field[][] getPlayerBoard() {
        return playerBoard;
    }

    public Field[][] getComputerBoard() {
        return computerBoard;
    }

    public Field[][] addShip (Field[][] tempField, int x, int y){
        ShipField shipField = new ShipField();
        if (tempField[x - 1][y - 1] == null){
            System.out.println("ship");
            shipField.emptyField();
            tempField[x - 1][y - 1] = shipField;
        } else {
            tempField[x - 1][y - 1] = null;
            System.out.println("null");
        }
        return tempField;
    }
    public Field[][] setNewFieldAtPlayerField(Field move) {
        ShootsLogic playerShootLogic = new ShootsLogic();
        playerShootLogic.shootValidator(playerBoard, move);
        return playerBoard;
    }

    public Field[][] setNewFieldAtComputerField(Field move) {
        ShootsLogic computerShootLogic = new ShootsLogic();
        computerShootLogic.shootValidator(computerBoard, move);
        return computerBoard;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    // wypełnia BOARD zgodnie z kryteriami FillCriterion
}
