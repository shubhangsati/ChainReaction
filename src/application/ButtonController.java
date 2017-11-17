package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class ButtonController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane onetwothree;

    @FXML
    public Button mrinal123;
    
    @FXML
    public Line line;

    @FXML
    void initialize() {
        assert onetwothree != null : "fx:id=\"onetwothree\" was not injected: check your FXML file 'Application.fxml'.";
        assert mrinal123 != null : "fx:id=\"mrinal123\" was not injected: check your FXML file 'Application.fxml'.";

    }
    
    public String retText() {
    	return mrinal123.getText();
    }
}
