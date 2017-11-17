package application;

import Game.SplitTimeline;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Molecule extends Group{
    private int atoms, TYPE, radius, criticalMass, row, column;
    private Board board;
    private double width, height;
    private PhongMaterial color;
    private Rotate rot1, rot2;
    private Timeline two, three;

    public Molecule(int t, int r, PhongMaterial C, double w, double h, int i, int j, Board gameBoard) {
        atoms = 0;
        TYPE = t;
        radius = r;
        color = C;
        width = w;
        height = h;
        row = i;
        column = j;
        board = gameBoard;

        if (TYPE < 4)
            criticalMass = 1;
        else if (TYPE >= 4 && TYPE < 8)
            criticalMass = 2;
        else
            criticalMass = 3;

        rot1 = new Rotate();
        rot2 = new Rotate();
        rot1.setPivotX(getLayoutX());
        rot1.setAxis(Rotate.Y_AXIS);
        rot1.setPivotZ(getLayoutY());

        rot2.setPivotY(getLayoutY());
        rot2.setAxis(Rotate.X_AXIS);
        rot2.setPivotZ(getLayoutY());

        two = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rot1.angleProperty(), 0d)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rot1.angleProperty(), 360, Interpolator.LINEAR))
        );
        two.setCycleCount(Timeline.INDEFINITE);
        two.setAutoReverse(false);

        three = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rot1.angleProperty(), 0d)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rot1.angleProperty(), 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(rot2.angleProperty(), 0d)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rot2.angleProperty(), 360, Interpolator.LINEAR))
        );
        three.setCycleCount(Timeline.INDEFINITE);
        three.setAutoReverse(false);
        setMouseTransparent(true);
    }

    public void addAtom() {
        if (atoms == 0 && atoms < criticalMass) {
            Sphere c = new Sphere(radius);
            c.setMaterial(color);
            getChildren().add(c);
            atoms++;
        }
        else if (atoms == 1 && atoms < criticalMass) {
            Sphere c = new Sphere(radius);
            c.setMaterial(color);
            c.setTranslateX(getLayoutX() + radius);
            getChildren().add(c);
            atoms++;
            getTransforms().addAll(rot1);

            two.play();
        }

        else if (atoms == 2 && atoms < criticalMass) {
            Sphere c = new Sphere(radius);
            c.setMaterial(color);
            c.setTranslateX(getLayoutX() + radius / 2);
            c.setTranslateY(getLayoutY() + radius / 2);
            getChildren().add(c);
            atoms++;
            getTransforms().addAll(rot2);
            two.stop();
            three.play();
        }
        else if (atoms == criticalMass) {
            Sphere c = new Sphere(radius);
            c.setMaterial(color);
            c.setTranslateX(getLayoutX() + radius / 2);
            c.setTranslateY(getLayoutY() + radius / 2);
            getChildren().add(c);
            atoms++;
            getTransforms().removeAll(rot1, rot2);
            Timeline splitAnimation = new SplitTimeline(this).getSplitAnimation(width, height);
            two.stop();
            three.stop();
            splitAnimation.play();
            splitAnimation.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    getChildren().removeAll(getChildren());
                    atoms = 0;
                    if (TYPE == 0) {
                        board.update(row + 1, column);
                        board.update(row, column + 1);
                    }
                    if (TYPE == 1) {
                        board.update(row + 1, column);
                        board.update(row, column - 1);
                    }
                    if (TYPE == 2) {
                        board.update(row - 1, column);
                        board.update(row, column - 1);
                    }
                    if (TYPE == 3) {
                        board.update(row - 1, column);
                        board.update(row, column + 1);
                    }
                    if (TYPE == 4) {
                        board.update(row + 1, column);
                        board.update(row, column - 1);
                        board.update(row, column + 1);
                    }
                    if (TYPE == 5) {
                        board.update(row, column - 1);
                        board.update(row - 1, column);
                        board.update(row + 1, column);
                    }
                    if (TYPE == 6) {
                        board.update(row - 1, column);
                        board.update(row, column - 1);
                        board.update(row, column + 1);
                    }
                    if (TYPE == 7) {
                        board.update(row, column + 1);
                        board.update(row - 1, column);
                        board.update(row + 1, column);
                    }
                    if (TYPE == 8) {
                        board.update(row, column - 1);
                        board.update(row, column + 1);
                        board.update(row - 1, column);
                        board.update(row + 1, column);
                    }
                }
            });
            /*
                0 4 1
                7 8 5
                3 6 2
             */

        }
    }

    public int getAtoms() {
        return atoms;
    }

    public void setAtoms(int atoms) {
        this.atoms = atoms;
    }

    public int getTYPE() {
        return TYPE;
    }

    public void setTYPE(int TYPE) {
        this.TYPE = TYPE;
    }

    public int getCriticalMass() {
        return criticalMass;
    }
}
