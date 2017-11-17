package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader root = new FXMLLoader(getClass().getResource("Application.fxml"));
		Scene scene = new Scene(root.load());
//		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//			@Override
//		    public void handle(MouseEvent mouseEvent) {
//		        System.out.println("mouse click detected! " + mouseEvent.getSource());
//		    }
//		};
		application.ButtonController hel = root.getController();
//		Line lol = hel.line;
//		System.out.println(hel.line.getClass());
//		System.out.println(lol.getClass());
//		lol.setStroke(Color.RED);
		hel.mrinal123.setOnAction(e->{
			
		        System.out.println("mouse click detected! " + ((Button) e.getSource()).getText());
		    }
		);
		//scene.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		System.out.println(hel.mrinal123.computeAreaInScreen());
//		System.out.println(onetwothree.getChildren());
//		primaryStage.setResizable(false);
		//initialize();
//		Button btn = (Button) scene.lookup("#mrinal123");
//		btn.setTextFill(Color.AQUA);
		primaryStage.setTitle("Chain Reaction");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
