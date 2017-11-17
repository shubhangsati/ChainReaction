
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

@SuppressWarnings("ALL")
public class Grid extends Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader root = new FXMLLoader(getClass().getResource("Grid9x6.fxml"));
        Group root3d = new Group();
        SubScene x = new SubScene(root3d, 335, 600, true, SceneAntialiasing.BALANCED);
        Group ROOT = new Group(root.load(), x);
        Scene scene = new Scene(ROOT);
        Grid9x6Controller gc = root.getController();
        GridPane top = gc.topGrid;
        AnchorPane pane = gc.grid;
        gc.getXY();
        primaryStage.setResizable(false);
        Board gameBoard = new Board(9, 6, 45, 47, 32, 45);
        root3d.getChildren().add(gameBoard);

        top.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Integer row = top.getRowIndex(item);
                    Integer col = top.getColumnIndex(item);
                    if (row == null) row = 0;
                    if (col == null) col = 0;
                    Molecule temp = gameBoard.getBoard()[row][col];
                    System.out.println(temp.getAtoms() + " " + temp.getCriticalMass());
                    temp.addAtom();
                }
            });
        });

        primaryStage.setTitle("Chain Reaction");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}