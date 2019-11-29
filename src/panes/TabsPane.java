package panes;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import tabs.*;

import java.util.ArrayList;

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
		Menu creditsMenu = new Menu("Credits");
		
		// Build menu items
		MenuItem exit = new MenuItem("Exit");
		
		// Set exit
		exit.setOnAction(e->{
			System.exit(0);
		});
		
		// Add menu items to the bar
		fileMenu.getItems().add(exit);
		menuTimeHub.getMenus().addAll(fileMenu, creditsMenu);
		
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
