package com.kodilla.GUI.main;

import com.kodilla.GUI.placing.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MajorControl extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Settings settings = new Settings();
            Scene configWindow = settings.configWindow(primaryStage);
            primaryStage.setTitle("SEA BATTLE");
            primaryStage.setScene(configWindow);
            primaryStage.setMinWidth(270);
            primaryStage.setMinHeight(150);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}