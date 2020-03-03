package com.kodilla.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Game {

    private Image imageback = new Image("textures/background.png");
    private Image title = new Image("textures/seaBattle.jpg");
    private DisplayedBoard boardGUI = new DisplayedBoard();

    public Scene start() {
        HBox box = new HBox();
        GridPane titlePane = new GridPane();
        ImageView imageView = new ImageView(title);
        imageView.setFitWidth(350);
        imageView.setFitHeight(150);
        titlePane.getChildren().add(imageView);
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
        leftBox.setAlignment(Pos.TOP_CENTER);

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        box.getChildren().addAll(leftBox, rightBox);
        box.setBackground(background);

        Scene scene = new Scene(box, 650, 550, Color.STEELBLUE);

        return scene;
    }
}



