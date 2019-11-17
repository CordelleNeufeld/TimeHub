/*
 * Provide the user with a home screen
 * 
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

package tabs;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import panes.TabsPane;

public class HomeTab extends Tab {
	
	private static HomeTab instance = null;

	private HomeTab() {
		
		//vbox for buttons
		VBox buttonsVBox = new VBox(50);
		
		//buttons for different tabs to navigate to
		Button categoriesButton = new Button("Categories");
		Button projectsButton = new Button("Projects");
		Button tasksButton = new Button("Tasks");
		
		//category button on-click listener
		categoriesButton.setOnAction(e -> {
			//make a new category tab and add it to the tabs and select it as the current tab
			CategoriesTab category = CategoriesTab.getInstance(new ArrayList<>());
			TabsPane.tabPane.getTabs().add(category);
			TabsPane.tabPane.getSelectionModel().select(category);
		});
		
		//projects button on-click listener
		projectsButton.setOnAction(e -> {
			//make a new project tab and add it to the tabs and select it as the current tab
			ProjectsTab project = ProjectsTab.getInstance(new ArrayList<>());
			TabsPane.tabPane.getTabs().add(project);
			TabsPane.tabPane.getSelectionModel().select(project);
		});
		
		//tasks button on-click listener
		tasksButton.setOnAction(e -> {
			//make a new tasks tab and add it to the tabs and select it as the current tab
			HourLogsTab hourLogs = HourLogsTab.getInstance(new ArrayList<>());
			TabsPane.tabPane.getTabs().add(hourLogs);
			TabsPane.tabPane.getSelectionModel().select(hourLogs);
		});
		
		//add all the buttons to the vbox and center the vbox
		buttonsVBox.getChildren().addAll(categoriesButton, projectsButton, tasksButton);
		buttonsVBox.setAlignment(Pos.CENTER);
		
		//add the buttons vbox to the tab
		this.setContent(buttonsVBox);
		// set title
		this.setText("Home");
		this.setClosable(false);
	}
	
	public static HomeTab getInstance() {
		if(instance == null) {
			instance = new HomeTab();
		}
    	
    	return instance;
    }
	
}
