package com.kodilla.GUI.spacing;

import com.kodilla.container.BoardContainer;
import com.kodilla.container.ShipContainer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class DisplayedBoard {
    private BoardContainer boardContainer = new BoardContainer();
    private int horizontal = BoardContainer.getHorizontal();
    private int vertical = BoardContainer.getVertical();
    private ShipContainer shipContainer;
    private IRefreshed iRefreshed;

    public GridPane getBoard(boolean buttons, ShipContainer shipContainer, IRefreshed iRefreshed) {
        this.shipContainer = shipContainer;
        this.iRefreshed = iRefreshed;
        GridPane grid = new GridPane();
        rowsAndColumns(grid);

        for (int i = 0; i < vertical * horizontal; i++) {
            if (buttons) {
                createButton(grid, i);
            } else {
                Label label = createLabel("");
                grid.add(label, i % horizontal + 1, i / horizontal + 1);
            }
            System.out.println(i + ": " + (i / horizontal + 1) + ", " + ((i % horizontal) + 1));
        }

        return frame(grid);
    }

    private void createButton(GridPane grid, int i) {
        Button button = createButton();
        int x = i % horizontal + 1;
        int y = i / horizontal + 1;
        button.setOnAction(e -> {
            System.out.println(x + "x" + y);
            if (boardContainer.getPlayerBoard()[x - 1][y - 1] == null) {
                button.setStyle("-fx-background-color: rgb(0,26,255); " +
                        "-fx-border-color: #000000; -fx-border-width: 1px;");
                shipContainer.setShipCounts(shipContainer.shipCounts + 1);
                System.out.println("Ships: " + shipContainer.shipCounts);
                System.out.println("Marked");
            } else {
                button.setStyle(null);
                shipContainer.setShipCounts(shipContainer.shipCounts - 1);
                System.out.println("Ships: " + shipContainer.shipCounts);
                System.out.println("Unmarked");
            }
            iRefreshed.refreshScore();
            boardContainer.addShip(boardContainer.getPlayerBoard(), x, y);
        });
        grid.add(button, i % horizontal + 1, i / horizontal + 1);
    }

    private GridPane frame(GridPane grid) {
        for (int x = 1; !(x > horizontal); x++) {
            Label label = createLabel(String.valueOf(x));
            grid.add(label, x, 0);
        }

        char a = 'A';
        for (int y = 1; !(y > vertical); y++, a++) {
            if (a == '[') a = 'a';
            Label label = createLabel(String.valueOf(a));
            grid.add(label, 0, y);
        }
        return grid;
    }

    private void rowsAndColumns(GridPane grid) {
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
    }

    private Button createButton() {
        Button button = new Button();
        button.setMinSize(30.0, 30.0);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
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