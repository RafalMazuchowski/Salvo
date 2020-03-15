package com.kodilla.GUI.clash;

import com.kodilla.GUI.placing.Settings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VictoryWindow {

    public static void display(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("END GAME");
        window.setMinWidth(250);
        window.setMinHeight(120);
        window.setMaxWidth(250);
        window.setMaxHeight(120);

        Label label = new Label();
        label.setText(message);

        Button exitButton = new Button("EXIT");
        exitButton.setOnAction(e -> window.close());
        Button restartButton = new Button("NEW GAME");
        restartButton.setOnAction(e -> {
            window.close();
            Settings settings = new Settings();
            Stage clearStage = new Stage();
            Scene configWindow = settings.configWindow(clearStage);
            clearStage.setTitle("SEA BATTLE");
            clearStage.setScene(configWindow);
            clearStage.setMinWidth(270);
            clearStage.setMinHeight(150);
            clearStage.show();
        });

        HBox buttonsBox = new HBox(10);
        buttonsBox.getChildren().addAll(restartButton, exitButton);
        buttonsBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, buttonsBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
