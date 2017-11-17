package Game;

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
    private Timeline splitAnimation;
    public SplitTimeline(Group molecule) {

        System.out.println(molecule.getTransforms().size());
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

    public Timeline getSplitAnimation() {
        Timeline t = new Timeline();
        if (numberOfMolecules == 2) {
            KeyFrame aStart = new KeyFrame(Duration.ZERO, new KeyValue(one.translateXProperty(), 0));
            KeyFrame aEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(one.translateXProperty(), -100));

            KeyFrame bStart = new KeyFrame(Duration.ZERO, new KeyValue(two.translateYProperty(), 0));
            KeyFrame bEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(two.translateYProperty(), -100));

            t.getKeyFrames().addAll(aStart, aEnd, bStart, bEnd);
        }

        if (numberOfMolecules == 3) {
            KeyFrame aStart = new KeyFrame(Duration.ZERO, new KeyValue(one.translateXProperty(), 0));
            KeyFrame aEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(one.translateXProperty(), -100));

            KeyFrame bStart = new KeyFrame(Duration.ZERO, new KeyValue(two.translateYProperty(), 0));
            KeyFrame bEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(two.translateYProperty(), -100));

            KeyFrame cStart = new KeyFrame(Duration.ZERO, new KeyValue(three.translateXProperty(), 0));
            KeyFrame cEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(three.translateXProperty(), 100));

            t.getKeyFrames().addAll(aStart, aEnd, bStart, bEnd, cStart, cEnd);
        }

        if (numberOfMolecules == 4) {
            KeyFrame aStart = new KeyFrame(Duration.ZERO, new KeyValue(one.translateXProperty(), 0));
            KeyFrame aEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(one.translateXProperty(), -100));

            KeyFrame bStart = new KeyFrame(Duration.ZERO, new KeyValue(two.translateYProperty(), 0));
            KeyFrame bEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(two.translateYProperty(), -100));

            KeyFrame cStart = new KeyFrame(Duration.ZERO, new KeyValue(three.translateXProperty(), 0));
            KeyFrame cEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(three.translateXProperty(), 100));

            KeyFrame dStart = new KeyFrame(Duration.ZERO, new KeyValue(four.translateYProperty(), 0));
            KeyFrame dEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(four.translateYProperty(), 100));

            t.getKeyFrames().addAll(aStart, aEnd, bStart, bEnd, cStart, cEnd, dStart, dEnd);
        }
        t.setAutoReverse(false);
        t.setCycleCount(1);
        return t;
    }
}
