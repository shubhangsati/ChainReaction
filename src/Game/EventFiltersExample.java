package Game;

import javafx.animation.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.transform.Rotate;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;

public class EventFiltersExample extends Application {
    @Override
    public void start(Stage stage) {

        Group molecule = new Group();
        molecule.setTranslateX(300);
        molecule.setTranslateY(150);
        molecule.setTranslateZ(150);
        Group root = new Group(molecule);

        //Animation
        Rotate rot1 = new Rotate();
        Rotate rot2 = new Rotate();

        rot1.setPivotX(molecule.getLayoutX() + 10);
        rot1.setAxis(Rotate.Y_AXIS);
        rot1.setPivotZ(molecule.getLayoutY());

        rot2.setPivotY(molecule.getLayoutY());
        rot2.setAxis(Rotate.X_AXIS);
        rot2.setPivotZ(molecule.getLayoutY());
        //rot.setPivotZ(molecule.getLayoutY());

        Timeline two = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rot1.angleProperty(), 0d)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rot1.angleProperty(), 360, Interpolator.LINEAR))
        );
        two.setCycleCount(Timeline.INDEFINITE);
        two.setAutoReverse(false);

        Timeline three = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rot1.angleProperty(), 0d)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rot1.angleProperty(), 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(rot2.angleProperty(), 0d)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rot2.angleProperty(), 360, Interpolator.LINEAR))
        );
        three.setCycleCount(Timeline.INDEFINITE);
        three.setAutoReverse(false);


                //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /*PhongMaterial redMaterial = new PhongMaterial();
                redMaterial.setDiffuseColor(Color.RED);
                redMaterial.setSpecularColor(Color.ORANGE);

                if (molecule.getChildren().toArray().length == 0) {
                    Sphere c = new Sphere(20);
                    c.setMaterial(redMaterial);
                    molecule.getChildren().add(c);
                }

                else if (molecule.getChildren().toArray().length == 1) {
                    Sphere c = new Sphere(20);
                    c.setMaterial(redMaterial);
                    c.setTranslateX(molecule.getLayoutX() + 20);
                    molecule.getChildren().add(c);
                    molecule.getTransforms().addAll(rot1);

                    two.play();
                }

                else if (molecule.getChildren().toArray().length == 2) {
                    Sphere c = new Sphere(20);
                    c.setMaterial(redMaterial);
                    c.setTranslateX(molecule.getLayoutX() + 10);
                    c.setTranslateY(molecule.getLayoutY() + 10);
                    molecule.getChildren().add(c);
                    molecule.getTransforms().addAll(rot2);
                    two.stop();
                    three.play();
                }

                else if (molecule.getChildren().size() == 3) {
                    Sphere c = new Sphere(20);
                    c.setMaterial(redMaterial);
                    c.setTranslateX(molecule.getLayoutX() + 10);
                    c.setTranslateY(molecule.getLayoutY() + 10);
                    molecule.getChildren().add(c);
                    molecule.getTransforms().removeAll(rot1, rot2);
                    //molecule.getTransforms().addAll(rot1, rot2);
                    two.stop();
                    three.stop();
                    Timeline splitAnimation = new SplitTimeline(molecule).getSplitAnimation();
                    splitAnimation.play();
                }*/
            }
        };

        Scene scene = new Scene(root, 600, 300, true, SceneAntialiasing.BALANCED);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        scene.setFill(Color.BLACK);
        stage.setTitle("Event Filters Example");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}