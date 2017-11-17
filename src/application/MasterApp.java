package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterApp extends Application{
	public static String sc1ID = "main";
	public static String sc1FX = "MainFX.fxml";
	public static String sc2ID = "choice";
	public static String sc2FX = "ChoiceFX.fxml";
	public static String sc3ID = "grid9x6";
	public static String sc3FX = "Grid9x6FX.fxml";
	public static String sc4ID = "grid15x10";
	public static String sc4FX = "Grid15x10FX.fxml";
	public static String sc5ID = "settings";
	public static String sc5FX = "SettingsFX.fxml";
	
	@Override
	public void start(Stage primaryStage) {
		ScreensController mainController = new ScreensController();
		mainController.loadScreen(MasterApp.sc1ID, MasterApp.sc1FX);
		mainController.loadScreen(MasterApp.sc2ID, MasterApp.sc2FX);
		mainController.loadScreen(MasterApp.sc3ID, MasterApp.sc3FX);
		mainController.loadScreen(MasterApp.sc4ID, MasterApp.sc4FX);
		mainController.loadScreen(MasterApp.sc5ID, MasterApp.sc5FX);
		
		mainController.setScreen(MasterApp.sc1ID);
		Group root = new Group();
		root.getChildren().addAll(mainController);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Chain Reaction");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
