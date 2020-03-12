package com.kodilla.fill;

import com.kodilla.container.BoardContainer;
import com.kodilla.container.ShipContainer;
import com.kodilla.fields.Field;

import java.util.Random;

public class ComputerBoard {
    private Random random = new Random();
    private BoardContainer boardContainer = new BoardContainer();
    private int existingShips;

    public Field[][] fillComputerBoard(Field[][] computerBoard){
        int x, y;
        int computerShips = (BoardContainer.getHorizontal() * BoardContainer.getVertical()) / 5;
        while (computerShips == existingShips) {

            do {
                x = random.nextInt(BoardContainer.getHorizontal());
                y = random.nextInt(BoardContainer.getVertical());
            } while (computerBoard[x][y] == null);

            boardContainer.addShip(boardContainer.getComputerBoard(), x, y);
            computerShips--;
        }
            return computerBoard;
    }
}
