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

public class PlayerSelect extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader root = new FXMLLoader(getClass().getResource("PlayerSelect.fxml"));
		Scene scene = new Scene(root.load());
//		PlayerSelectController grid = root.getController();
//		GridPane top = grid.topGrid;
//		grid.getXY();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Chain Reaction");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
