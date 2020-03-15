package com.kodilla.container;

import com.kodilla.fields.Field;
import com.kodilla.fields.ShipField;

public class BoardContainer {
    private static final BoardContainer INSTANCE = new BoardContainer();

    private int horizontal;
    private int vertical;
    private Field[][] playerBoard;
    private Field[][] computerBoard;

    private BoardContainer() {
        horizontal = 10;
        vertical = 10;
    }

    public static BoardContainer getInstance() {
        return INSTANCE;
    }

    public void setSize(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        createBoards();
        //playerBoard = new Field[BoardContainer.horizontal][BoardContainer.vertical];
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public int getShipsCount() {
        return (horizontal * vertical) / 4;
    }

    public Field[][] getPlayerBoard() {
        if (playerBoard == null) {
            createBoards();
        }
        return playerBoard;
    }

    public Field[][] getComputerBoard() {
        if (computerBoard == null) {
            createBoards();
        }
        return computerBoard;
    }

    public void addPlayerShip(int x, int y) {
        ShipField shipField = new ShipField();
        if (playerBoard[x - 1][y - 1] == null) {
            System.out.println("ship");
            shipField.emptyField();
            playerBoard[x - 1][y - 1] = shipField;
        } else {
            playerBoard[x - 1][y - 1] = null;
            System.out.println("null");
        }
    }

    private void createBoards() {
        playerBoard = new Field[horizontal][vertical];
        computerBoard = new Field[horizontal][vertical];
    }

    /*public Field[][] setNewFieldAtPlayerField(Field move) {
        ShootsLogic playerShootLogic = new ShootsLogic();
        playerShootLogic.shootValidator(playerBoard, move);
        return playerBoard;
    }

    public Field[][] setNewFieldAtComputerField(Field move) {
        ShootsLogic computerShootLogic = new ShootsLogic();
        computerShootLogic.shootValidator(computerBoard, move);
        return computerBoard;
    }*/

/*
    public void setVertical(int vertical) {
        BoardContainer.vertical = vertical;
        //playerBoard = new Field[BoardContainer.horizontal][BoardContainer.vertical];
    }*/

    // wypełnia BOARD zgodnie z kryteriami FillCriterion
}
