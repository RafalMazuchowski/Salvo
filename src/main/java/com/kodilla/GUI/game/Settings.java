package com.kodilla.GUI.game;

import com.kodilla.container.BoardContainer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Settings {
    public Scene configWindow(Stage primaryStage) {
        BoardContainer boardContainer = new BoardContainer();
        Game gameScene = new Game();
        VBox vBox = new VBox();
        HBox col = new HBox(), row = new HBox();
        Label empty = new Label();

        Label title = new Label();
        title.setText("SEA BATTLE");
        title.setPrefSize(70, 50);

        Label xLabel = new Label("Columns: ");
        xLabel.setText("Columns: ");
        xLabel.setPrefSize(60, 30);
        TextField xField = new TextField(String.valueOf(10));

        Label yLabel = new Label("Rows: ");
        yLabel.setText("Rows: ");
        yLabel.setPrefSize(60, 30);
        TextField yField = new TextField(String.valueOf(10));

        Button okButton = new Button("OK");

        activeButton(xField, yField, okButton);

        okButton.setOnAction(e -> {
            boardContainer.setHorizontal(Integer.parseInt(xField.getText()));
            boardContainer.setVertical(Integer.parseInt(yField.getText()));
            primaryStage.setScene(gameScene.start());
            primaryStage.setX(200);
            primaryStage.setY(50);
            primaryStage.setMinWidth(650);
            primaryStage.setMinHeight(550);}
        );

        col.getChildren().addAll(xLabel, xField);
        col.setAlignment(Pos.CENTER);
        row.getChildren().addAll(yLabel, yField);
        row.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(title, col, row, empty, okButton);
        vBox.setAlignment(Pos.CENTER);
        return new Scene(vBox, 200, 200, Color.DEEPSKYBLUE);
    }

    private void activeButton(TextField xField, TextField yField, Button okButton) {
        xField.setOnAction(e -> {
            int xValue = Integer.parseInt(xField.getText());
            int yValue = Integer.parseInt(yField.getText());
            if((xValue > 5 && xValue < 50) && (yValue > 5 && yValue < 50)){
                System.out.println("Good size");
                okButton.setDisable(false);
            } else {
                okButton.setDisable(true);
                System.out.println("TO BIG!");
            }
        });
    }
}