package com.kodilla.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class MajorControl extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Game gameScene = new Game();
            ConfigWindow configWindow = new ConfigWindow();
            primaryStage.setTitle("Salvo");
            primaryStage.setScene(configWindow.start());
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(500);
            primaryStage.show();
            primaryStage.setScene(gameScene.start());
            primaryStage.show();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}



