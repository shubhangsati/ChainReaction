package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class SettingsController implements Initializable,ControlledScreen {
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
    private AnchorPane colorShower;
    
    @FXML
    private ComboBox<Integer> choiceBox;

    @FXML
    private Button saveSettings;
    
    @FXML
    private Slider rValue;

    @FXML
    private Slider gValue;

    @FXML
    private Slider bValue;

    @FXML
    void initializeSliders(MouseEvent event) {
    	Double r = rValue.getValue();
    	Double g = gValue.getValue();
    	Double b = bValue.getValue();
    	Color show = Color.rgb(r.intValue(), g.intValue(), b.intValue());
    	colorShower.setBackground(new Background(new BackgroundFill(show, CornerRadii.EMPTY, Insets.EMPTY)));
    }
//    
//    @FXML
//    void initialize() {
////        assert mainMenu != null : "fx:id=\"mainMenu\" was not injected: check your FXML file 'PlayerSelect.fxml'.";
//        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'PlayerSelect.fxml'.";
//        assert saveSettings != null : "fx:id=\"saveSettings\" was not injected: check your FXML file 'PlayerSelect.fxml'.";
//        choiceBox.setValue(2);
//        choiceBox.getItems().addAll(2,3,4,5,6,7,8);
////        this.initializeSliders();
////        rValue.getValue()
////        this.initializeSliders();
////        colorShower.setStyle("-fx-background-color: rgb("+(int)rValue.getValue()+","+(int)gValue.getValue()+","+(int)bValue.getValue()+")");
////        colorShower.setBackground(new Color((int)1,(int)2,(int)3));
//    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'PlayerSelect.fxml'.";
        assert saveSettings != null : "fx:id=\"saveSettings\" was not injected: check your FXML file 'PlayerSelect.fxml'.";
        choiceBox.setValue(2);
        choiceBox.getItems().addAll(2,3,4,5,6,7,8);
		
	}
}
