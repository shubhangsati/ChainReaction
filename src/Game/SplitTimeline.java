package Game;

import application.Molecule;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class SplitTimeline{
    private Sphere one;
    private Sphere two;
    private Sphere three;
    private Sphere four;
    private int numberOfMolecules;
    private int type;
    private Timeline splitAnimation;
    public SplitTimeline(Molecule molecule) {
        type = molecule.getTYPE();

        numberOfMolecules = molecule.getChildren().size();
        if (numberOfMolecules == 2) {
            one = (Sphere) molecule.getChildren().get(0);
            two = (Sphere) molecule.getChildren().get(1);
            one.setTranslateZ(0); one.setTranslateX(0); one.setTranslateY(0);
            two.setTranslateZ(0); two.setTranslateX(0); two.setTranslateY(0);
        }

        else if (numberOfMolecules == 3) {
            one = (Sphere) molecule.getChildren().get(0);
            two = (Sphere) molecule.getChildren().get(1);
            three = (Sphere) molecule.getChildren().get(2);
            one.setTranslateZ(0); one.setTranslateX(0); one.setTranslateY(0);
            two.setTranslateZ(0); two.setTranslateX(0); two.setTranslateY(0);
            three.setTranslateZ(0); three.setTranslateX(0); three.setTranslateY(0);
        }

        else if (numberOfMolecules == 4) {
            one = (Sphere) molecule.getChildren().get(0);
            two = (Sphere) molecule.getChildren().get(1);
            three = (Sphere) molecule.getChildren().get(2);
            four = (Sphere) molecule.getChildren().get(3);
            one.setTranslateZ(0); one.setTranslateX(0); one.setTranslateY(0);
            two.setTranslateZ(0); two.setTranslateX(0); two.setTranslateY(0);
            three.setTranslateZ(0); three.setTranslateX(0); three.setTranslateY(0);
            four.setTranslateZ(0); four.setTranslateX(0);; four.setTranslateY(0);
        }
    }

    public Timeline getSplitAnimation(double width, double height) {
        Timeline t = new Timeline();
        if (numberOfMolecules == 2) {
            /*
                0 4 1
                7 8 5
                3 6 2
             */
            KeyValue aEndKV = new KeyValue(one.translateXProperty(), 0);
            KeyValue bEndKV = new KeyValue(one.translateYProperty(), 0);
            if (type == 0 || type == 3)
                aEndKV = new KeyValue(one.translateXProperty(), width);
            if (type == 1 || type == 2)
                aEndKV = new KeyValue(one.translateXProperty(), -width);
            if (type == 0 || type == 1)
                bEndKV = new KeyValue(two.translateYProperty(), height);
            if (type == 3 || type == 2)
                bEndKV = new KeyValue(two.translateYProperty(), -height);

            KeyFrame aStart = new KeyFrame(Duration.ZERO, new KeyValue(one.translateXProperty(), 0));
            KeyFrame aEnd = new KeyFrame(Duration.seconds(0.5), aEndKV);

            KeyFrame bStart = new KeyFrame(Duration.ZERO, new KeyValue(two.translateYProperty(), 0));
            KeyFrame bEnd = new KeyFrame(Duration.seconds(0.5), bEndKV);

            t.getKeyFrames().addAll(aStart, aEnd, bStart, bEnd);
        }

        if (numberOfMolecules == 3) {
            KeyFrame aStart = new KeyFrame(Duration.ZERO, new KeyValue(one.translateXProperty(), 0));
            KeyFrame aEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(one.translateXProperty(), -width));

            KeyFrame bStart = new KeyFrame(Duration.ZERO, new KeyValue(two.translateYProperty(), 0));
            KeyFrame bEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(two.translateYProperty(), -width));

            KeyFrame cStart = new KeyFrame(Duration.ZERO, new KeyValue(three.translateXProperty(), 0));
            KeyFrame cEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(three.translateXProperty(), width));

            t.getKeyFrames().addAll(aStart, aEnd, bStart, bEnd, cStart, cEnd);
        }

        if (numberOfMolecules == 4) {
            KeyFrame aStart = new KeyFrame(Duration.ZERO, new KeyValue(one.translateXProperty(), 0));
            KeyFrame aEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(one.translateXProperty(), -width));

            KeyFrame bStart = new KeyFrame(Duration.ZERO, new KeyValue(two.translateYProperty(), 0));
            KeyFrame bEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(two.translateYProperty(), -width));

            KeyFrame cStart = new KeyFrame(Duration.ZERO, new KeyValue(three.translateXProperty(), 0));
            KeyFrame cEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(three.translateXProperty(), width));

            KeyFrame dStart = new KeyFrame(Duration.ZERO, new KeyValue(four.translateYProperty(), 0));
            KeyFrame dEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(four.translateYProperty(), width));

            t.getKeyFrames().addAll(aStart, aEnd, bStart, bEnd, cStart, cEnd, dStart, dEnd);
        }
        t.setAutoReverse(false);
        t.setCycleCount(1);
        return t;
    }
}
