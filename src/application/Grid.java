package application;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
		Scene scene = new Scene(root.load());
		GridController grid = root.getController();
		GridPane top = grid.topGrid;

		top.getChildren().forEach(item -> {
		    item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Integer row = top.getRowIndex(item);
                    Integer column = top.getColumnIndex(item);
                    if (row == null) row = 0;
                    if (column == null) column = 0;
                    System.out.println(row + " " + column);
                }
            });
        });

		primaryStage.setResizable(false);
		primaryStage.setTitle("Chain Reaction");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
