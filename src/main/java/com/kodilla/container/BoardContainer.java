package com.kodilla.container;

import com.kodilla.commander.ShootsLogic;
import com.kodilla.fields.Field;
import com.kodilla.fields.ShipField;

public class BoardContainer {

    private static int horizontal = 10;
    private static int vertical = 10;
    private Field[][] playerBoard = new Field[BoardContainer.horizontal][BoardContainer.vertical];
    private Field[][] computerBoard = new Field[BoardContainer.horizontal][BoardContainer.vertical];

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

    public static int getHorizontal() {
        return horizontal;
    }

    public static int getVertical() {
        return vertical;
    }

    public static int getShipsCount(){
        return (horizontal * vertical) / 5;
    }

    public void setSize(int horizontal, int vertical) {
        BoardContainer.horizontal = horizontal;
        BoardContainer.vertical = vertical;
        //playerBoard = new Field[BoardContainer.horizontal][BoardContainer.vertical];
    }
/*
    public void setVertical(int vertical) {
        BoardContainer.vertical = vertical;
        //playerBoard = new Field[BoardContainer.horizontal][BoardContainer.vertical];
    }*/

    // wypełnia BOARD zgodnie z kryteriami FillCriterion
}
