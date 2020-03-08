package com.kodilla.fill;

import com.kodilla.container.BoardContainer;
import com.kodilla.fields.Field;

import java.util.Random;

public class ComputerBoard {
    private BoardContainer boardContainer = new BoardContainer();
    private Random random = new Random();

    public Field[][] fillComputerBoard(int i){
        int x, y;
        i = 20;
        Field[][] computerBoard = boardContainer.getComputerBoard();
        while (i == 0) {
            do {
                x = random.nextInt(BoardContainer.getHorizontal());
                y = random.nextInt(BoardContainer.getVertical());
            } while (computerBoard[x][y] == null);
            boardContainer.addShip(boardContainer.getComputerBoard(), x, y);
            i--;
        }
            return computerBoard;
    }
}
