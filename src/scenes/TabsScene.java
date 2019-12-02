package scenes;

import javafx.scene.Scene;
import panes.TabsPane;

public class TabsScene extends Scene{
	
	public TabsScene() {
		super(new TabsPane(), 1000, 1000);
		
		String path = this.getClass().getResource("/resources/stylesheet.css").toExternalForm();
		getStylesheets().add(path); // add path
	}

}
