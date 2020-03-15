package com.kodilla.GUI.placing;

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
        ShipsSetupScene shipsSetupScene = new ShipsSetupScene();
        VBox vBox = new VBox();
        HBox col = new HBox(), row = new HBox();
        Label empty = new Label();

        Label title = new Label();
        title.setText("SEA BATTLE");
        title.setPrefSize(70, 50);

        Label xLabel = new Label("Columns: ");
        xLabel.setText("Columns: ");
        xLabel.setPrefSize(60, 30);
        TextField xField = new TextField("10");

        Label yLabel = new Label("Rows: ");
        yLabel.setText("Rows: ");
        yLabel.setPrefSize(60, 30);
        TextField yField = new TextField("10");

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            BoardContainer.getInstance().setSize(Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText()));
            primaryStage.setScene(shipsSetupScene.start(primaryStage));
            primaryStage.setX(200);
            primaryStage.setY(50);
            primaryStage.setMinWidth(880);
            primaryStage.setMinHeight(660);
        });
        activeButton(xField, yField, okButton);

        col.getChildren().addAll(xLabel, xField);
        col.setAlignment(Pos.CENTER);
        row.getChildren().addAll(yLabel, yField);
        row.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(title, col, row, empty, okButton);
        vBox.setAlignment(Pos.CENTER);
        return new Scene(vBox, 200, 240, Color.DEEPSKYBLUE);
    }

    private void activeButton(TextField xField, TextField yField, Button okButton) {
        xField.setOnKeyReleased(e -> {
            changedValue(xField, yField, okButton);
        });
        yField.setOnKeyReleased(e -> {
            changedValue(xField, yField, okButton);
        });
    }

    private void changedValue(TextField xField, TextField yField, Button okButton) {
        if (xField.getText().length() > 0 && yField.getText().length() > 0) {
            int xValue = Integer.parseInt(xField.getText());
            int yValue = Integer.parseInt(yField.getText());
            if (((xValue >= 5) && (xValue <= 30)) && ((yValue >= 5) && (yValue <= 30))) {
                System.out.println("Good size");
                okButton.setDisable(false);
            } else {
                okButton.setDisable(true);
                System.out.println("TO BIG!");
            }
            System.out.println("Value X: " + xValue + ", Y: " + yValue);
        }
    }
}