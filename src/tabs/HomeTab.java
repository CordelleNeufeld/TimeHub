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

	public HomeTab() {
		
		VBox buttonsVBox = new VBox(50);
		
		Button categoriesButton = new Button("Categories");
		Button projectsButton = new Button("Projects");
		Button tasksButton = new Button("Tasks");
		
		categoriesButton.setOnAction(e -> {
			CategoriesTab category = new CategoriesTab(new ArrayList<>());
			TabsPane.tabPane.getTabs().add(category);
			TabsPane.tabPane.getSelectionModel().select(category);
		});
		
		projectsButton.setOnAction(e -> {
			ProjectsTab project = new ProjectsTab(new ArrayList<>(), TabsPane.tabPane);
			TabsPane.tabPane.getTabs().add(project);
			TabsPane.tabPane.getSelectionModel().select(project);
		});
		
		tasksButton.setOnAction(e -> {
			HourLogsTab hourLogs = new HourLogsTab(new ArrayList<>());
			TabsPane.tabPane.getTabs().add(hourLogs);
			TabsPane.tabPane.getSelectionModel().select(hourLogs);
		});
		
		buttonsVBox.getChildren().addAll(categoriesButton, projectsButton, tasksButton);
		buttonsVBox.setAlignment(Pos.CENTER);
		
		//add the buttons vbox to the tab
		this.setContent(buttonsVBox);
		// set title
		this.setText("Home");
	}
	
}
