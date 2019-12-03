package scenes;

import javafx.scene.Scene;
import panes.LoginPane;

public class LoginScene extends Scene {

    public LoginScene() {
        super(new LoginPane(), 2048 * 0.6, 1536 * 0.6);

        String path = this.getClass().getResource("/resources/stylesheet.css").toExternalForm();
        getStylesheets().add(path);
    }
}