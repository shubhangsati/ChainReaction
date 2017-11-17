package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

public class PlayerSelectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainMenu;

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
    void initialize() {
        assert mainMenu != null : "fx:id=\"mainMenu\" was not injected: check your FXML file 'PlayerSelect.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'PlayerSelect.fxml'.";
        assert saveSettings != null : "fx:id=\"saveSettings\" was not injected: check your FXML file 'PlayerSelect.fxml'.";
        choiceBox.setValue(2);
        choiceBox.getItems().addAll(2,3,4,5,6,7,8);
    }
}
