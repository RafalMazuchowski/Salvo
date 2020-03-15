package com.kodilla.GUI.clash;

import com.kodilla.GUI.main.DisplayedBoard;
import com.kodilla.GUI.main.IRefreshed;
import com.kodilla.container.BoardContainer;
import com.kodilla.container.ShipContainer;
import com.kodilla.fields.Field;
import com.kodilla.fields.ShipField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Random;

public class GameScene implements IRefreshed {

    private Image imageback = new Image("textures/background.png");
    private Image title = new Image("textures/seaBattle.jpg");
    private DisplayedBoard displayedBoard;
    private BoardContainer boardContainer = BoardContainer.getInstance();

    private ShipContainer shipContainer = new ShipContainer();

    private Label playersShips;
    private Label cpuShips;

    public Scene start() {
        displayedBoard = new DisplayedBoard();
        boardContainer.generatedComputerShips();
        HBox hBox = new HBox();
        VBox rightBox = new VBox();
        VBox leftBox = new VBox();
        rightBox.setAlignment(Pos.TOP_CENTER);
        leftBox.setAlignment(Pos.TOP_CENTER);

        GridPane titlePane = getTitle();
        GridPane mainGrid = getMainGrid();
        GridPane childGrid = getChildGrid();
        GridPane scorePane = getScoreGrid();

        leftBox.getChildren().add(titlePane);
        leftBox.getChildren().add(mainGrid);
        leftBox.setAlignment(Pos.TOP_CENTER);

        rightBox.getChildren().add(childGrid);
        rightBox.getChildren().add(scorePane);

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        hBox.getChildren().addAll(leftBox, rightBox);
        hBox.setBackground(background);

        Scene scene = new Scene(hBox, Color.STEELBLUE);
        displayedBoard.updateLabels();
        return scene;
    }

    private GridPane getTitle() {
        GridPane titlePane = new GridPane();
        ImageView imageView = new ImageView(title);
        imageView.setFitWidth(350);
        imageView.setFitHeight(150);
        titlePane.getChildren().add(imageView);
        return titlePane;
    }

    private GridPane getMainGrid() {
        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        mainGrid.setHgap(5.5);
        mainGrid.setVgap(5.5);
        mainGrid.getChildren().add(displayedBoard.getBoard(true, true, shipContainer, this));
        return mainGrid;
    }

    private GridPane getChildGrid() {
        GridPane childGrid = new GridPane();
        childGrid.setAlignment(Pos.CENTER);
        childGrid.setPadding(new Insets(20.5, 20.5, 20.5, 20.5));
        childGrid.setHgap(5.5);
        childGrid.setVgap(5.5);
        childGrid.getChildren().add(displayedBoard.getBoard(false, false, shipContainer, this));
        return childGrid;
    }

    private GridPane getScoreGrid() {
        GridPane scorePane = new GridPane();
        scorePane.setAlignment(Pos.CENTER);
        scorePane.setStyle("-fx-background-color: #0089b3;" +
                "-fx-border-color: #ffffff;");
        playersShips = new Label(shipContainer.getShipCounts() + "/" + boardContainer.getShipsCount());
        cpuShips = new Label(shipContainer.getShipCounts() + "/" + boardContainer.getShipsCount());
        Label describe = new Label("SUNKEN SHIPS: ");
        Label playerDes = new Label("PLAYER: ");
        Label cpuDes = new Label("CPU: ");
        scorePane.add(describe, 1, 0);
        scorePane.add(playerDes, 0, 1);
        scorePane.add(cpuDes, 0, 2);
        scorePane.add(playersShips, 1, 1);
        scorePane.add(cpuShips, 1, 2);
        scorePane.setHalignment(describe, HPos.LEFT);
        scorePane.setHalignment(playersShips, HPos.CENTER);
        scorePane.setHalignment(cpuShips, HPos.CENTER);
        scorePane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        scorePane.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        scorePane.setHgap(30);
        scorePane.setPadding(new Insets(10));
        return scorePane;
    }

    @Override
    public void refreshScore() {
        playersShips.setText(shipContainer.getShipCounts() + "/" + boardContainer.getShipsCount());
        cpuShips.setText(shipContainer.getShipCounts() + "/" + boardContainer.getShipsCount());

    }
}

