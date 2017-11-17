package application;

import Game.SplitTimeline;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
		Scene scene = new Scene(root.load(), 335, 600, true);
        GridController grid = root.getController();
		GridPane top = grid.topGrid;
		top.setTranslateZ(-10);

		top.getChildren().forEach(item -> {
		    item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Integer row = top.getRowIndex(item);
                    Integer column = top.getColumnIndex(item);
                    if (row == null) row = 0;
                    if (column == null) column = 0;
                    System.out.println(row + " " + column);
                    Sphere c = new Sphere(15);
                    c.setTranslateX(item.getLayoutX() + 5);
                    c.setTranslateY(item.getLayoutY() - 5);
                    c.setTranslateZ(10);
                    top.getChildren().add(c);
                    System.out.println(top.getTranslateZ());
                    System.out.println(c.getTranslateZ());
                }
            });
        });

		primaryStage.setResizable(false);
		primaryStage.setTitle("Chain Reaction");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
