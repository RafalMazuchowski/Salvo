package com.kodilla.container;

import com.kodilla.fields.Field;
import com.kodilla.fields.ShipField;
import com.kodilla.fields.ShootField;

import java.util.Random;

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

    public boolean addPlayerShip(int x, int y) {
        ShipField shipField = new ShipField();
        if (playerBoard[x][y] == null) {
            System.out.println("ship");
            playerBoard[x][y] = shipField;
            return true;
        } else {
            playerBoard[x][y] = null;
            System.out.println("null");
            return false;
        }
    }

    public boolean processPlayerHit(int x, int y) {
        if (computerBoard[x][y] == null) {
            computerBoard[x][y] = new ShootField();
            System.out.println("Water...");
            return false;
        } else {
            ((ShipField) computerBoard[x][y]).setHit(true);
            System.out.println("Ship was hit!");
            return true;
        }
    }

    public Field getPlayerField(int x, int y) {
        return playerBoard[x][y];
    }

    public void generatedComputerShips() {
        int x, y;
        Random random = new Random();
        int shipsTarget = getShipsCount();
        int computerShips = 0;
        while (computerShips < shipsTarget) {

            do {
                x = random.nextInt(getHorizontal());
                y = random.nextInt(getVertical());
            } while (computerBoard[x][y] != null);

            computerBoard[x][y] = new ShipField();
            computerShips++;
        }
        System.out.println(">> COMPUTER PLACING <<");
        for (int i = 0; i < computerBoard.length; i++){
            for (int j = 0; j < computerBoard[i].length; j++){
                System.out.println((char)(j + 65) + " " + (i + 1) + " : " + ((computerBoard[i][j] != null) ? "Ship" : "-"));
            }
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
