package ChainReaction;

import javafx.animation.*;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;


public class GameScreen extends Application {

    private static final double SIZE = 300;
    private final Content content = Content.create(SIZE);

    public void play() {
        content.animation.play();
    }

    private static final class Content {

        private static final Duration DURATION = Duration.seconds(4);
        private final Group group = new Group();
        private final Group group1 = new Group();
        private final Group mainGroup = new Group();
        private final Sphere atom1;
        private final Sphere atom2;
        private final Sphere atom3;

        private final Sphere atom4;
        private final Sphere atom5;
        private final Sphere atom6;
        private final Animation animation;

        private static Content create(double size) {
            Content c = new Content(size / 4);
            c.group.getChildren().addAll(c.atom1, c.atom2, c.atom3);
            c.group.setTranslateX(size / 2);
            c.group.setTranslateY(size / 2);
            c.group.setTranslateZ(size / 2);


            c.group1.getChildren().addAll(c.atom4, c.atom5);
            c.group1.setTranslateX(size);
            c.group1.setTranslateY(size / 2);
            c.group1.setTranslateZ(size / 2);

            c.mainGroup.getChildren().addAll(c.group, c.group1);
            return c;
        }

        private Content(double size) {
            PhongMaterial redMaterial = new PhongMaterial();
            redMaterial.setDiffuseColor(Color.RED);
            redMaterial.setSpecularColor(Color.ORANGE);

            PhongMaterial blueMaterial = new PhongMaterial();
            blueMaterial.setDiffuseColor(Color.BLUE);
            blueMaterial.setSpecularColor(Color.VIOLET);

            atom1 = new Sphere(size / 4);
            atom1.setMaterial(redMaterial);

            atom2 = new Sphere(size / 4);
            atom2.setMaterial(redMaterial);
            atom2.setTranslateX(size / 4);

            atom3 = new Sphere(size / 4);
            atom3.setMaterial(redMaterial);
            atom3.setTranslateX(size / 8);
            atom3.setTranslateY(size / 4);

            atom4 = new Sphere(size / 4);
            atom4.setMaterial(blueMaterial);

            atom5 = new Sphere(size / 4);
            atom5.setMaterial(blueMaterial);
            atom5.setTranslateX(size / 4);

            atom6 = new Sphere(size / 4);
            atom6.setMaterial(blueMaterial);
            atom6.setTranslateX(size / 8);
            atom6.setTranslateY(size / 4);

            animation = createTimeline(size);
        }


        private Timeline createTimeline(double size) {
            Rotate rot1 = new Rotate();
            Rotate rot2 = new Rotate();

            rot1.setPivotX(group.getLayoutX() + size / 8);
            rot1.setAxis(Rotate.Y_AXIS);
            rot1.setPivotZ(group.getLayoutY());

            rot2.setPivotY(group.getLayoutY());
            rot2.setAxis(Rotate.X_AXIS);
            rot2.setPivotZ(group.getLayoutY());

            group.getTransforms().setAll(rot1, rot2);


            Rotate rotg1 = new Rotate();

            rotg1.setPivotX(group1.getLayoutX() + size / 8);
            rotg1.setAxis(Rotate.Y_AXIS);
            rotg1.setPivotZ(group1.getLayoutY());


            group1.getTransforms().setAll(rotg1);
            Timeline t = new Timeline(
                   /* new KeyFrame(Duration.ZERO, new KeyValue(rot1.angleProperty(), 0d)),
                    new KeyFrame(Duration.seconds(2), new KeyValue(rot1.angleProperty(), 360, Interpolator.LINEAR)),
                    new KeyFrame(Duration.ZERO, new KeyValue(rot2.angleProperty(), 0d)),
                    new KeyFrame(Duration.seconds(2), new KeyValue(rot2.angleProperty(), 360, Interpolator.LINEAR)),
*/
                    new KeyFrame(Duration.ZERO, new KeyValue(rotg1.angleProperty(), 0d)),
                    new KeyFrame(Duration.seconds(2), new KeyValue(rotg1.angleProperty(), 360, Interpolator.LINEAR))


            );
            t.setCycleCount(Timeline.INDEFINITE);
            t.setAutoReverse(false);
            return t;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Molecule");
        Scene scene = new Scene(content.mainGroup, SIZE * 2, SIZE * 2, true);
        primaryStage.setScene(scene);
        scene.setFill(Color.BLACK);
        primaryStage.show();
        play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
