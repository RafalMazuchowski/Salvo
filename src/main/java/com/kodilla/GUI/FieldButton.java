package com.kodilla.GUI;

import javafx.scene.control.Button;

public class FieldButton {

    public Button getButton() {
        Button button = new Button();
        button.setMaxSize(20.0, 20.0);
        button.setMinSize(20.0, 20.0);
        button.setOnAction(e -> System.out.println("BUM"));
        return button;
    }
}
