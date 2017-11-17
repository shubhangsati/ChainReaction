package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GridController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public AnchorPane grid;

    @FXML
    public GridPane bottonGrid;

    @FXML
    public GridPane topGrid;

    @FXML
    void initialize() {
        assert grid != null : "fx:id=\"grid\" was not injected: check your FXML file 'Grid.fxml'.";
        assert bottonGrid != null : "fx:id=\"bottonGrid\" was not injected: check your FXML file 'Grid.fxml'.";
        assert topGrid != null : "fx:id=\"topGrid\" was not injected: check your FXML file 'Grid.fxml'.";

    }
    
}