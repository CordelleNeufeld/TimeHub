package panes;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import tabs.AddHoursTab;
import tabs.HomeTab;
import tabs.OrganizeTab;
import tabs.StatsTab;

/*
 * Provide the user with a screen to add daily hours
 * 
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

public class TabsPane extends BorderPane {
	
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
		TabPane tabPane = new TabPane();
		
		// Set auto-policy to prevent user from closing tabs
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		// Create the tabs
		HomeTab homeTab = new HomeTab();
		AddHoursTab addHoursTab = new AddHoursTab();
		OrganizeTab organizeTab = new OrganizeTab();
		StatsTab statsTab = new StatsTab();
		
		// Populate the TabPane
		tabPane.getTabs().addAll(homeTab, addHoursTab, organizeTab, statsTab, new TaskForm(), new ProjectOverview(null));
				
		// Set the top of the BorderPane to the MenuBar
		setTop(menuTimeHub);
		
		// Set the center of the BorderPane to the TabPane
		setCenter(tabPane);
		
	}

}
