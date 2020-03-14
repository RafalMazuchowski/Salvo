package com.kodilla.GUI.clash;

import com.kodilla.GUI.main.DisplayedBoard;
import com.kodilla.GUI.main.IRefreshed;
import com.kodilla.container.BoardContainer;
import com.kodilla.container.ShipContainer;
import com.kodilla.fields.Field;
import com.kodilla.fields.ShipField;
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
    private ShipContainer shipContainer = new ShipContainer();

    private Label shipLabel;

    public Scene start() {
        displayedBoard = new DisplayedBoard();
        generatedComputerShips(BoardContainer.getComputerBoard());
        HBox box = new HBox();
        VBox rightBox = new VBox();
        VBox leftBox = new VBox();

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

        box.getChildren().addAll(leftBox, rightBox);
        box.setBackground(background);

        Scene scene = new Scene(box, Color.STEELBLUE);
        displayedBoard.updateLabels(BoardContainer.getPlayerBoard());
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
        shipLabel = new Label(shipContainer.getShipCounts() + "/" + BoardContainer.getShipsCount());
        Label shipQty = new Label("SUNK: ");
        scorePane.setPrefSize(70, 50);
        scorePane.add(shipQty, 0, 0);
        scorePane.add(shipLabel, 2, 0);
        return scorePane;
    }

    private void generatedComputerShips(Field[][] board) {
        int x, y;
        Random random = new Random();
        int shipsTarget = BoardContainer.getShipsCount();
        int computerShips = 0;
        while (computerShips < shipsTarget) {

            do {
                x = random.nextInt(BoardContainer.getHorizontal());
                y = random.nextInt(BoardContainer.getVertical());
            } while (board[x][y] != null);

            board[x][y] = new ShipField();
            computerShips++;
        }
        System.out.println(">> COMPUTER PLACING <<");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.println((char)(j + 65) + " " + (i + 1) + " : " + ((board[i][j] != null) ? "Ship" : "-"));
            }
        }
    }

    @Override
    public void refreshScore() {
        shipLabel.setText(shipContainer.getShipCounts() + "/" + BoardContainer.getShipsCount());
    }
}

