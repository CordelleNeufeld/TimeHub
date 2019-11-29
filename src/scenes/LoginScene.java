package scenes;

import javafx.scene.Scene;
import panes.LoginPane;

public class LoginScene extends Scene {

	public LoginScene() {
		super(new LoginPane(), 1000, 1000);
		
		String path = this.getClass().getResource("/resources/stylesheet.css").toExternalForm();
		this.getStylesheets().add(path);
		
		
	}

}
