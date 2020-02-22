package com.kodilla.GUI;

import com.kodilla.fill.BoardFiller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class Board {
    private BoardFiller boardFiller = new BoardFiller();
    private int horizontal = boardFiller.getHorizontal();
    private int vertical = boardFiller.getVertical();

    public GridPane getBoard(boolean buttons) {
        GridPane grid = new GridPane();
        for (int row = 0; !(row > horizontal); row++) {
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0; !(col > vertical); col++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        for (int i = 0; i < vertical * horizontal; i++) {

            //ShipField asdasd = playerField[0][0] instanceof ShipField ? (ShipField) playerField[0][0] : null;
            if (buttons) {
                Button button = createButton(Integer.toString(i + 1));
                grid.add(button, i % horizontal + 1, i / horizontal + 1);
            } else {
                Label label = createLabel("");
                grid.add(label, i % horizontal + 1, i / horizontal + 1);
            }
            System.out.println(i + ": " + (i / horizontal + 1) + ", " + ((i % horizontal) + 1));
        }

        for (int x = 1; !(x > horizontal); x++){
            Label label = createLabel(String.valueOf(x));
            grid.add(label, x, 0);
        }

        char a = 'A';
        for (int y = 1; !(y > vertical); y++, a++){
            if (a == '`') a = 'a';
            Label label = createLabel(String.valueOf(a));
            grid.add(label, 0, y);
        }
        return grid;
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMinSize(20.0, 20.0);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(e -> System.out.println(text));
        return button;
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setText(text);
        label.setMinSize(20.0, 20.0);
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-border-color: black;");
        return label;
    }
}
