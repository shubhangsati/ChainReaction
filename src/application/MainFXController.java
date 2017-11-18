package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class MainFXController implements ControlledScreen {
	
	ScreensController control;
	
	@Override
	public void setScreenParent(ScreensController screenpage) {
		control = screenpage;
	}
	
	@FXML
    private AnchorPane mainMenu;

    @FXML
    private Button newGame;

    @FXML
    private Button resumeGame;

    @FXML
    private Button settings;

    @FXML
    void goToChoice(ActionEvent event) {
        control.setScreen(MasterApp.sc2ID);
    }

    @FXML
    void goToSaved(ActionEvent event) {

    }

    @FXML
    void goToSettings(ActionEvent event) {
        control.setScreen(MasterApp.sc5ID);
    }
    
    
    
    @FXML
    void initialize() {
//        assert onetwothree != null : "fx:id=\"onetwothree\" was not injected: check your FXML file 'Application.fxml'.";
//        assert mrinal123 != null : "fx:id=\"mrinal123\" was not injected: check your FXML file 'Application.fxml'.";
    	System.out.println(mainMenu.getBoundsInParent().getHeight());
    	System.out.println(mainMenu.getBoundsInParent().getWidth());
    }
}
