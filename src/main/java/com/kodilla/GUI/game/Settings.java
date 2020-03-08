package com.kodilla.GUI.game;

import com.kodilla.container.BoardContainer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Settings {
    private int sliderValue;

    public int getSliderValue() {
        return sliderValue;
    }

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
        TextField xField = new TextField("10");

        Label yLabel = new Label("Rows: ");
        yLabel.setText("Rows: ");
        yLabel.setPrefSize(60, 30);
        TextField yField = new TextField("10");

        Button okButton = new Button("OK");

        Label sLabel = new Label();

        Slider slider = new Slider(5, 100, 10);
        slider.setBlockIncrement(40);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        slider.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number>
                                                observable, Number oldValue, Number newValue) {

                        sLabel.setText("Ships: " + newValue);
                    }
                });
        sliderValue = (int) slider.getValue();



        activeButton(xField, yField, okButton);

        okButton.setOnAction(e -> {
                    boardContainer.setSize(Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText()));
                    primaryStage.setScene(gameScene.start());
                    primaryStage.setX(200);
                    primaryStage.setY(50);
                    primaryStage.setMinWidth(650);
                    primaryStage.setMinHeight(550);
                    this.sliderValue = getSliderValue();
                }
        );

        col.getChildren().addAll(xLabel, xField);
        col.setAlignment(Pos.CENTER);
        row.getChildren().addAll(yLabel, yField);
        row.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(title, col, row, sLabel, slider, empty, okButton);
        vBox.setAlignment(Pos.CENTER);
        return new Scene(vBox, 200, 200, Color.DEEPSKYBLUE);
    }

    private void activeButton(TextField xField, TextField yField, Button okButton) {
        xField.setOnKeyReleased(e -> {
            changedValue(xField, yField, okButton);
            System.out.println("Value: " + Integer.parseInt(xField.getText()));
        });
        yField.setOnKeyReleased(e -> {
            changedValue(xField, yField, okButton);
            System.out.println("Value: " + Integer.parseInt(yField.getText()));
        });
    }

    private void changedValue(TextField xField, TextField yField, Button okButton) {
        int xValue = Integer.parseInt(xField.getText());
        int yValue = Integer.parseInt(yField.getText());

        if (((xValue > 5) && (xValue <= 30)) && ((yValue > 5) && (yValue <= 30))) {
            System.out.println("Good size");
            okButton.setDisable(false);
        } else {
            okButton.setDisable(true);
            System.out.println("TO BIG!");
        }
    }
}