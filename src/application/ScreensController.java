package application;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ScreensController extends StackPane{
	private HashMap<String,Node> screens = new HashMap<>();
	public void addScreen (String screenName, Node screen) {
		screens.put(screenName, screen);
	}
	public Node retScreen(String screenName) {
		return screens.get(screenName);
	}
	public boolean loadScreen(String screenName, String fxLink) {
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource(fxLink));
			Parent currentScreen = (Parent) (root.load());
			ControlledScreen tempController = ((ControlledScreen) root.getController());
			tempController.setScreenParent(this);
			addScreen(screenName, currentScreen);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean setScreen(String screenName) {
		if (screens.get(screenName)!=null) {
			if(!getChildren().isEmpty()) {	
				getChildren().remove(0);
				getChildren().add(0,screens.get(screenName));
			}
			else getChildren().add(screens.get(screenName));
			return true;
		}
		else {
			System.out.println("Screen not loaded");
			return false;
		}
	}
	public boolean unloadScreen(String screenName) {
		if(screens.remove(screenName)==null) {
			System.out.println("Screen wasn't present");
			return false;
		}
		else return true;
	}
}
