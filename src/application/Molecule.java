package application;

import Game.SplitTimeline;
import javafx.animation.*;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Molecule extends Group{
    private int atoms, TYPE, radius;
    private double width;
    private PhongMaterial color;
    private Rotate rot1, rot2;
    private Timeline two, three;

    public Molecule(int t, int r, PhongMaterial C, double w) {
        atoms = 0;
        TYPE = t;
        radius = r;
        color = C;
        width = w;

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
        if (atoms == 0) {
            Sphere c = new Sphere(radius);
            c.setMaterial(color);
            getChildren().add(c);
            atoms++;
        }
        else if (atoms == 1) {
            Sphere c = new Sphere(radius);
            c.setMaterial(color);
            c.setTranslateX(getLayoutX() + radius);
            getChildren().add(c);
            atoms++;
            getTransforms().addAll(rot1);

            two.play();
        }

        else if (atoms == 2) {
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

        else if (atoms == 3) {
            Sphere c = new Sphere(radius);
            c.setMaterial(color);
            c.setTranslateX(getLayoutX() + radius / 2);
            c.setTranslateY(getLayoutY() + radius / 2);
            getChildren().add(c);
            atoms++;
            getTransforms().removeAll(rot1, rot2);
            //molecule.getTransforms().addAll(rot1, rot2);
            two.stop();
            three.stop();
            Timeline splitAnimation = new SplitTimeline(this).getSplitAnimation(width);
            splitAnimation.play();
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
}
