package com.kodilla.GUI.placing;

import com.kodilla.GUI.main.DisplayedBoard;
import com.kodilla.GUI.main.IRefreshed;
import com.kodilla.GUI.clash.GameScene;
import com.kodilla.container.BoardContainer;
import com.kodilla.container.ShipContainer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShipsSetupScene implements IRefreshed {

    private Image imageback = new Image("textures/background.png");
    private Image title = new Image("textures/seaBattle.jpg");
    private DisplayedBoard displayedBoard;
    private ShipContainer shipContainer = new ShipContainer();

    private Label shipLabel;
    private Button startGameButton;
    private Stage primaryStage;

    public Scene start(Stage stage) {
        this.primaryStage = stage;
        displayedBoard = new DisplayedBoard();
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
        mainGrid.getChildren().add(displayedBoard.getBoard(true, false, shipContainer, this));
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
        shipLabel = new Label(shipContainer.getShipCounts() + "/" + BoardContainer.getInstance().getShipsCount());
        Label shipQty = new Label("SHIPS: ");
        startGameButton = new Button("START");
        startGameButton.setOnAction(e -> {
            primaryStage.setScene(new GameScene().start());

        });
        startGameButton.setDisable(true);
        scorePane.setPrefSize(70, 50);
        scorePane.add(shipQty, 0, 0);
        scorePane.add(shipLabel, 2, 0);
        scorePane.add(startGameButton, 1, 2);
        return scorePane;
    }

    @Override
    public void refreshScore() {
        shipLabel.setText(shipContainer.getShipCounts() + "/" + BoardContainer.getInstance().getShipsCount());
        startGameButton.setDisable(shipContainer.getShipCounts() != BoardContainer.getInstance().getShipsCount());
    }
}