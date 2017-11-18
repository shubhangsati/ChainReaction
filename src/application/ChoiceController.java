package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class ChoiceController implements ControlledScreen {
	ScreensController control;
	
	@Override
	public void setScreenParent(ScreensController screenpage) {
		control = screenpage;
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainMenu;

    @FXML
    private ComboBox<Integer> choiceBox;

    @FXML
    private RadioButton button9x6;

    @FXML
    private ToggleGroup gridSize;

    @FXML
    private RadioButton button15x10;

    @FXML
    private Button startButton;

    private boolean radioButtonValue() {
    	if(button9x6.isSelected()) 
    		return false;
    	else
    		return true;
    }
    
    @FXML
    void goToGrid(ActionEvent event) {
    	if(!radioButtonValue()) control.setScreen(MasterApp.sc3ID);
    	else control.setScreen(MasterApp.sc4ID);

    }
    
    @FXML
    void goToMenu(ActionEvent event) {
    	control.setScreen(MasterApp.sc1ID);
    }


    @FXML
    void initialize() {
//        assert mainMenu != null : "fx:id=\"mainMenu\" was not injected: check your FXML file 'Selection.fxml'.";
//        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'Selection.fxml'.";
//        assert gridSize != null : "fx:id=\"gridSize\" was not injected: check your FXML file 'Selection.fxml'.";
//        assert newGame != null : "fx:id=\"newGame\" was not injected: check your FXML file 'Selection.fxml'.";
        choiceBox.setValue(2);
//        this.radioButtonValue();
        choiceBox.getItems().addAll(2,3,4,5,6,7,8);
    }
}