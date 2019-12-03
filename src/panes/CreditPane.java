package panes;

import java.io.File;

import classes.Database;
import home.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import scenes.LoginScene;
import scenes.TabsScene;

public class CreditPane extends BorderPane{
	
	public CreditPane() {
		
		// Build menu bar
		MenuBar menuTimeHub = new MenuBar();
		Menu fileMenu = new Menu("File");
		
		// Build menu items
		MenuItem home = new MenuItem("Home");
		MenuItem changeDB = new MenuItem("Change Database");
		MenuItem exit = new MenuItem("Exit");

		//Set ChangeDB
		changeDB.setOnAction(e->  {
			File configFile = new File("config.txt");
			if(new File("config.txt").exists()) {
				configFile.delete();
				Database.clearInstance();
			}
			Main.mainStage.setScene(new LoginScene());
		});
		home.setOnAction(e -> Main.mainStage.setScene(new TabsScene()));

		// Set exit
		exit.setOnAction(e-> System.exit(0));
		
		// Add menu items to the bar
		fileMenu.getItems().addAll(home, changeDB, exit);
		menuTimeHub.getMenus().addAll(fileMenu);
		
		//Build VBox
		VBox root = new VBox();
		root.setSpacing(30);
		root.setAlignment(Pos.CENTER);
		
		//Title
		Text title = new Text("Credits");
		title.setFont(Font.font("Courier New",FontWeight.BOLD, 30));
		root.getChildren().add(title);
		
		//Credits
		String[] creditItems = {"Hasan Muslemani", "Abel Anderson", "Cordelle Neufeld", "Vectors by Vecteezy.com"};
		
		for(String credit: creditItems) {
			root.getChildren().add(new Text(credit));
		}
		
		//Set-up Parent
		setTop(menuTimeHub);
		setCenter(root);
		
	}
}
