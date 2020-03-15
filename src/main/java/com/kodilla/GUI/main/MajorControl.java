package com.kodilla.GUI.main;

import com.kodilla.GUI.placing.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MajorControl extends Application {

    private static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public static void close() {
        System.out.println("Exit program.");
        window.close();
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            window = primaryStage;
            Settings settings = new Settings();
            Scene configWindow = settings.configWindow(window);
            window.setTitle("SEA BATTLE");
            window.setScene(configWindow);
            window.setMinWidth(270);
            window.setMinHeight(150);
            window.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}