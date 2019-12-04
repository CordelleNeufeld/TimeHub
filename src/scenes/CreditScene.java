package scenes;

import javafx.scene.Scene;
import panes.CreditPane;
import panes.LoginPane;

public class CreditScene extends Scene{
	public CreditScene() {
        super(new CreditPane(), 2048 * 0.6, 1536 * 0.6);

        String path = this.getClass().getResource("/resources/stylesheet.css").toExternalForm();
        getStylesheets().add(path);
    }
}
