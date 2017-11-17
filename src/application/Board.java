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
                int type = 0;
                /*
                    0 4 1
                    7 8 5
                    3 6 2
                 */
                if (i == 0 && j == 0) type = 0;
                if (i == 0 && j != 0 && j != m - 1) type = 4;
                if (i == 0 && j == m - 1) type = 1;
                if (j == 0 && i != 0 && i != n - 1) type = 7;
                if (j == 0 && i == n - 1) type = 3;
                if (i == n - 1 && j != 0 && j != m - 1) type = 6;
                if (i == n - 1 && j == m - 1) type = 2;
                if (i != 0 && i != n - 1 && j == m - 1 ) type = 5;
                if (i != 0 && i != n - 1 && j != 0 && j != m - 1) type = 8;
                board[i][j] = new Molecule(type, 10, redMaterial, width, height);
                board[i][j].setTranslateX(topx + width * j + width / 2);
                board[i][j].setTranslateY(topy + height * i + height / 2);
                getChildren().add(board[i][j]);
            }
        }
    }

    public Molecule[][] getBoard() {
        return board;
    }
}
