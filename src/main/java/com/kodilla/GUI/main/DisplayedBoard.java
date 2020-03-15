package com.kodilla.GUI.main;

import com.kodilla.container.BoardContainer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class DisplayedBoard {
    private IRefreshed iRefreshed;
    private Label[][] labels;
    private BoardContainer boardContainer = BoardContainer.getInstance();

    public GridPane getBoard(boolean buttons, boolean game, IRefreshed iRefreshed) {
        this.iRefreshed = iRefreshed;
        GridPane grid = new GridPane();
        rowsAndColumns(grid);
        labels = new Label[boardContainer.getHorizontal()][boardContainer.getVertical()];
        System.out.println("Generating board...");

        for (int i = 0; i < boardContainer.getVertical() * boardContainer.getHorizontal(); i++) {
            if (!game) {
                if (buttons) {
                    placingButton(grid, i);
                } else {
                    Label label = createLabel("");
                    labels[i % boardContainer.getHorizontal()][i / boardContainer.getHorizontal()] = label;
                    grid.add(label, i % boardContainer.getHorizontal() + 1, i / boardContainer.getHorizontal() + 1);
                }
                System.out.println(i + ": " + (i / boardContainer.getHorizontal() + 1) + ", " + ((i % boardContainer.getHorizontal()) + 1));
            } else {
                clashButton(grid, i);
            }
        }
        return frame(grid);
    }

    public void updateLabels() {
        for (int i = 0; i < boardContainer.getHorizontal(); i++) {
            for (int j = 0; j < boardContainer.getVertical(); j++) {
                if (boardContainer.getPlayerField(i, j) != null) {
                    labels[i][j].setStyle("-fx-background-color: rgb(0,26,255); " +
                            "-fx-border-color: #343434; -fx-border-width: 1px;");
                }
            }
        }
    }

    private void placingButton(GridPane grid, int i) {
        Button button = createButton();
        int x = i % boardContainer.getHorizontal() + 1;
        int y = i / boardContainer.getHorizontal() + 1;
        button.setOnAction(e -> {
            System.out.println(x + "x" + y);
            if (boardContainer.addPlayerShip(x - 1, y - 1)) {
                button.setStyle("-fx-background-color: rgb(0,26,255); " +
                        "-fx-border-color: #000000; -fx-border-width: 1px;");
                System.out.println("Ships: " + BoardContainer.getInstance().getPlayerShipsCount());
                System.out.println("Marked");
            } else {
                button.setStyle(null);
                System.out.println("Ships: " + BoardContainer.getInstance().getPlayerShipsCount());
                System.out.println("Unmarked");
            }
            iRefreshed.refreshScore();
        });
        grid.add(button, i % boardContainer.getHorizontal() + 1, i / boardContainer.getHorizontal() + 1);
    }

    private void clashButton(GridPane grid, int i) {
        Button button = createButton();
        int x = i % boardContainer.getHorizontal() + 1;
        int y = i / boardContainer.getHorizontal() + 1;
        button.setOnAction(e -> {
            System.out.println(x + "x" + y);
            if (boardContainer.processPlayerHit(x - 1, y - 1)) {
                button.setStyle("-fx-background-color: rgb(225,38,0); " +
                        "-fx-border-color: #000000; -fx-border-width: 1px;");
                System.out.println("Ships: " + BoardContainer.getInstance().getPlayerShipsCount());
                System.out.println("HIT!");
            } else {
                button.setStyle("-fx-background-color: rgb(75,75,75); " +
                        "-fx-border-color: rgb(52,52,52); -fx-border-width: 1px;");
                System.out.println("Ships: " + BoardContainer.getInstance().getPlayerShipsCount());
                System.out.println("MISS");
            }
            button.setDisable(true);
            button.setOpacity(80.0);
            iRefreshed.refreshScore();
        });
        grid.add(button, i % boardContainer.getHorizontal() + 1, i / boardContainer.getHorizontal() + 1);
    }

    private GridPane frame(GridPane grid) {
        for (int x = 1; !(x > boardContainer.getHorizontal()); x++) {
            Label label = createLabel(String.valueOf(x));
            grid.add(label, x, 0);
        }

        char a = 'A';
        for (int y = 1; !(y > boardContainer.getVertical()); y++, a++) {
            if (a == '[') a = 'a';
            Label label = createLabel(String.valueOf(a));
            grid.add(label, 0, y);
        }
        return grid;
    }

    private void rowsAndColumns(GridPane grid) {
        for (int row = 0; !(row > boardContainer.getHorizontal()); row++) {
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }

        for (int col = 0; !(col > boardContainer.getVertical()); col++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }
    }

    private Button createButton() {
        Button button = new Button();
        button.setMinSize(40.0, 40.0);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return button;
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setText(text);
        label.setMinSize(30.0, 30.0);
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-border-color: black;");
        return label;
    }
}