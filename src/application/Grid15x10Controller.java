package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Grid15x10Controller implements ControlledScreen{
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
    public AnchorPane grid;

    @FXML
    private GridPane bottonGrid;

    @FXML
    public GridPane topGrid;

    @FXML
    void initialize() {
        assert grid != null : "fx:id=\"grid\" was not injected: check your FXML file 'Grid.fxml'.";
        assert bottonGrid != null : "fx:id=\"bottonGrid\" was not injected: check your FXML file 'Grid.fxml'.";
        assert topGrid != null : "fx:id=\"topGrid\" was not injected: check your FXML file 'Grid.fxml'.";

    }
    void getXY() {
    	topGrid.getChildren().forEach(item -> {
		    item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Integer row = topGrid.getRowIndex(item);
                    Integer column = topGrid.getColumnIndex(item);
                    if (row == null) row = 0;
                    if (column == null) column = 0;
                    System.out.println(row + " " + column);
                }
            });
        });
    }
    
}