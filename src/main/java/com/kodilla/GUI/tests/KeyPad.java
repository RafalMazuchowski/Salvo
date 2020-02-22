package com.kodilla.GUI.tests;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class KeyPad extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        int numRows = 4 ;
        int numColumns = 3 ;
        for (int row = 0 ; row < numRows ; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0 ; col < numColumns; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        for (int i = 0 ; i < 9 ; i++) {
            Button button = createButton(Integer.toString(i+1));
            grid.add(button, i % 3, i / 3);
        }
        grid.add(createButton("#"), 0, 3);
        grid.add(createButton("0"), 1, 3);
        grid.add(createButton("*"), 2, 3);

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(e -> System.out.println(text));
        return button ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}