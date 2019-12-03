package panes;

import java.io.File;

import classes.Database;
import home.Main;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import scenes.CreditScene;
import scenes.LoginScene;
import tabs.*;

/*
 * Provide the user with a screen to add daily hours
 * 
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

public class TabsPane extends BorderPane {
	
	public static TabPane tabPane;
	
	public TabsPane() {
			
		// Build menu bar
		MenuBar menuTimeHub = new MenuBar();
		Menu fileMenu = new Menu("File");
		
		// Build menu items
		MenuItem changeDB = new MenuItem("Change Database");
		MenuItem credits = new MenuItem("Credits");
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
		credits.setOnAction(e -> Main.mainStage.setScene(new CreditScene()));

		// Set exit
		exit.setOnAction(e-> System.exit(0));
		
		// Add menu items to the bar
		fileMenu.getItems().addAll(changeDB, credits, exit);
		menuTimeHub.getMenus().addAll(fileMenu);
		
		// Create a TabPane
		tabPane = new TabPane();
				
		// Populate the TabPane
		tabPane.getTabs().addAll(HomeTab.getInstance(), StatsTab.getInstance(), CategoriesTab.getInstance(), ProjectsTab.getInstance(), TasksTab.getInstance());
				
		// Set the top of the BorderPane to the MenuBar
		setTop(menuTimeHub);
		
		// Set the center of the BorderPane to the TabPane
		setCenter(tabPane);
		
	}

}
