package com.kodilla.fill;

import com.kodilla.boards.Board;
import com.kodilla.commander.ShootsLogic;
import com.kodilla.fields.Field;

public class BoardFiller implements Board {
    private Field[][] playerBoard;
    private Field[][] computerBoard;

    public Field[][] board (int horizontal, int vertical){
        Field[][] newBoard = new Field[horizontal][vertical];
        for (int i = 0; i < horizontal; i++){
            for (int j = 0; j < vertical; j++){
                newBoard[i][j] = null;
                }
            }
        return newBoard;
    }

    public Field[][] fillPlayerBoards (){
        playerBoard = board(10,10);
        return playerBoard;
    }

    public Field[][] fillComputerBoards (){
        computerBoard = board(10,10);
        return computerBoard;
    }

    public Field[][] setNewFieldAtPlayerField (Field move){
        ShootsLogic playerShootLogic = new ShootsLogic();
        playerShootLogic.shootValidator(playerBoard, move);
        return playerBoard;
    }

    public Field[][] setNewFieldAtComputerField (Field move){
        ShootsLogic computerShootLogic = new ShootsLogic();
        computerShootLogic.shootValidator(computerBoard, move);
        return computerBoard;
    }

    public Field[][] getPlayerBoard() {
        return playerBoard;
    }

    public Field[][] getComputerBoard() {
        return computerBoard;
    }

    // wypełnia BOARD zgodnie z kryteriami FillCriterion
}
