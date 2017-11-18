
package application;

import Game.SplitTimeline;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
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

        FXMLLoader root = new FXMLLoader(getClass().getResource("Grid9x6FX.fxml"));
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
        Players playersList = new Players(2);
        /*top.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Integer row = top.getRowIndex(item);
                    Integer col = top.getColumnIndex(item);
                    if (row == null) row = 0;
                    if (col == null) col = 0;
                    Molecule temp = gameBoard.getBoard()[row][col];
                    temp.addAtom();
                }
            });
        });*/

        Border initBorder = new Border(new BorderStroke(playersList.list[playersList.currentPlayer].material.getDiffuseColor(), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS));
        top.getChildren().forEach(it -> {
            Button tempButton = (Button) it;
            tempButton.setBorder(initBorder);
        });

        top.getChildren().forEach(item -> {
            item.setOnMouseClicked(event -> {
                Integer row = top.getRowIndex(item);
                Integer col = top.getColumnIndex(item);
                if (row == null) row = 0;
                if (col == null) col = 0;
                Molecule temp = gameBoard.getBoard()[row][col];
                int nextplayer = playersList.currentPlayer;

                if (temp.getColor().getDiffuseColor() == playersList.list[playersList.currentPlayer].material.getDiffuseColor()) {
                    temp.addAtom();
                    nextplayer = (playersList.currentPlayer + 1) % playersList.numberOfPlayer;
                    playersList.currentPlayer = nextplayer;
                }
                else if (temp.getColor().getDiffuseColor() == temp.defaultColor.getDiffuseColor()) {
                    temp.setColor(playersList.list[playersList.currentPlayer].material);
                    temp.addAtom();
                    nextplayer = (playersList.currentPlayer + 1) % playersList.numberOfPlayer;
                    playersList.currentPlayer = nextplayer;
                }
                Border tempBorder = new Border(new BorderStroke(playersList.list[nextplayer].material.getDiffuseColor(), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS));
                top.getChildren().forEach(it -> {
                    Button tempButton = (Button) it;
                    tempButton.setBorder(tempBorder);
                });
            });
        });

        primaryStage.setTitle("Chain Reaction");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}