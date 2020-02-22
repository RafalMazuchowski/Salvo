package com.kodilla.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Game {
    private Board boardGUI = new Board();
    public Scene start(){
            HBox box = new HBox();
            Pane titlePane = new Pane();
            titlePane.setMinSize(100.0, 100.0);
            Pane mainBoardPane = new Pane();
            Pane childBoardPane = new Pane();
            Pane scorePane = new Pane();
            VBox rightBox = new VBox();
            VBox leftBox = new VBox();

            GridPane mainGrid = new GridPane();
            mainGrid.setAlignment(Pos.CENTER);
            mainGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            mainGrid.setHgap(5.5);
            mainGrid.setVgap(5.5);
            mainGrid.getChildren().add(boardGUI.getBoard(true));

            mainBoardPane.getChildren().add(mainGrid);

            GridPane childGrid = new GridPane();
            childGrid.setAlignment(Pos.CENTER);
            childGrid.setPadding(new Insets(20.5, 20.5, 20.5, 20.5));
            childGrid.setHgap(5.5);
            childGrid.setVgap(5.5);
            childGrid.getChildren().add(boardGUI.getBoard(false));

            childBoardPane.getChildren().add(childGrid);

            rightBox.getChildren().add(childBoardPane);
            rightBox.getChildren().add(scorePane);

            leftBox.getChildren().add(titlePane);
            leftBox.getChildren().add(mainBoardPane);

            box.getChildren().addAll(leftBox,rightBox);

            Scene scene = new Scene(box, 800, 500, Color.DEEPSKYBLUE);

           return scene;
    }
}



