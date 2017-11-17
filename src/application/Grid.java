package application;

import Game.SplitTimeline;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
//import javafx.scene.control.Button;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.StackPane;

public class Grid extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader root = new FXMLLoader(getClass().getResource("Grid.fxml"));
        Group root3d = new Group();
        SubScene x = new SubScene(root3d, 335, 600, true, SceneAntialiasing.BALANCED);
        Group ROOT = new Group(root.load(), x);
		Scene scene = new Scene(ROOT);
        GridController gc = root.getController();
		GridPane top = gc.topGrid;
        AnchorPane pane = gc.grid;

        //*************************************************
        Group molecule = new Group();
        Rotate rot1 = new Rotate();
        Rotate rot2 = new Rotate();

        rot1.setPivotX(molecule.getLayoutX());
        rot1.setAxis(Rotate.Y_AXIS);
        rot1.setPivotZ(molecule.getLayoutY());

        rot2.setPivotY(molecule.getLayoutY());
        rot2.setAxis(Rotate.X_AXIS);
        rot2.setPivotZ(molecule.getLayoutY());
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
        root3d.getChildren().add(molecule);
        //********************************************
        molecule.getChildren().forEach(item -> {
            item.setOnMouseClicked(System.out::println);
        });
        top.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    molecule.setTranslateX(top.getLayoutX() + item.getLayoutX() + item.getLayoutBounds().getWidth() / 2);
                    molecule.setTranslateY(top.getLayoutY() + item.getLayoutY() + item.getLayoutBounds().getHeight() / 2);
                    PhongMaterial redMaterial = new PhongMaterial();
                    redMaterial.setDiffuseColor(Color.RED);
                    redMaterial.setSpecularColor(Color.ORANGE);

                    if (molecule.getChildren().toArray().length == 0) {
                        Sphere c = new Sphere(10);
                        c.setMaterial(redMaterial);
                        molecule.getChildren().add(c);
                    }

                    else if (molecule.getChildren().toArray().length == 1) {
                        Sphere c = new Sphere(10);
                        c.setMaterial(redMaterial);
                        c.setTranslateX(molecule.getLayoutX() + 10);
                        molecule.getChildren().add(c);
                        molecule.getTransforms().addAll(rot1);

                        two.play();
                    }

                    else if (molecule.getChildren().toArray().length == 2) {
                        Sphere c = new Sphere(10);
                        c.setMaterial(redMaterial);
                        c.setTranslateX(molecule.getLayoutX() + 5);
                        c.setTranslateY(molecule.getLayoutY() + 5);
                        molecule.getChildren().add(c);
                        molecule.getTransforms().addAll(rot2);
                        two.stop();
                        three.play();
                    }

                    else if (molecule.getChildren().size() == 3) {
                        Sphere c = new Sphere(10);
                        c.setMaterial(redMaterial);
                        c.setTranslateX(molecule.getLayoutX() + 5);
                        c.setTranslateY(molecule.getLayoutY() + 5);
                        molecule.getChildren().add(c);
                        molecule.getTransforms().removeAll(rot1, rot2);
                        //molecule.getTransforms().addAll(rot1, rot2);
                        two.stop();
                        three.stop();
                        Timeline splitAnimation = new SplitTimeline(molecule).getSplitAnimation(item.getLayoutBounds().getWidth());
                        splitAnimation.play();
                    }
                }
            });
        });
        primaryStage.setResizable(false);
		primaryStage.setTitle("Chain Reaction");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
