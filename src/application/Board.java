package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

public class Board extends Group {
    private Molecule[][] board;
    private double width, height;
    private double topx, topy;

    public Board(int n, int m, double w, double h, double tx, double ty) {
        width = w;
        height = h;
        topx = tx;
        topy = ty;
        PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.RED);
        redMaterial.setSpecularColor(Color.ORANGE);
        board = new Molecule[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] = new Molecule(0, 10, redMaterial, width);
                board[i][j].setTranslateX(topx + width * j + width / 2);
                board[i][j].setTranslateY(topy + height * i + height / 2);
                System.out.println(board[i][j].getTranslateX());
                getChildren().add(board[i][j]);
            }
        }
    }

    public Molecule[][] getBoard() {
        return board;
    }
}
