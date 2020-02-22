package com.kodilla.GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class ConfigWindow {
    public Scene start(){
        Pane box = new Pane();
        Label title = new Label();
        title.setText("SEA BATTLE");

        Label x = new Label();
        x.setText("Columns: ");
        TextField xField = new TextField();

        Label y = new Label();
        y.setText("Rows: ");
        TextField yField = new TextField();

        Button ok = new Button();
        box.getChildren().addAll(title, x, y, ok);

        Scene scene = new Scene(box, 800, 500, Color.DEEPSKYBLUE);
        return scene;
    }
}
