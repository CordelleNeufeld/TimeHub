package scenes;

import javafx.scene.Scene;
import panes.TabsPane;

public class TabsScene extends Scene{
	
	public TabsScene() {
		super(new TabsPane(), 2048 * 0.6, 1536 * 0.6);
		
		String path = this.getClass().getResource("/resources/stylesheet.css").toExternalForm();
		getStylesheets().add(path); // add path
	}

}
