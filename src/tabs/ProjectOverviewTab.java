package tabs;

import javabeans.Project;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ProjectOverviewTab extends Tab{
	
	public ProjectOverviewTab(Project project) {
		
		//vbox to hold the project name, description and add project button
		VBox mainVBox = new VBox(30);
		
		Text projectName = new Text("Title");
		
		TextArea projectDesc = new TextArea("Description");
		
		Button addProject = new Button("Add Project");
		
		//add to the vbox
		mainVBox.getChildren().addAll(projectName, projectDesc, addProject);
		
		//hbox to combine the vbox and tabpane
		HBox mainHBox = new HBox(30);
		
		//tabpane for the graph
		TabPane tabPane = new TabPane();
		
		//make the tabs non-closable
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		//add to the tabs
		tabPane.getTabs().addAll(new Tab("Tab 1"), new Tab("Tab 2"));
		
		//add to the hbox the vbox and tabpane
		mainHBox.getChildren().addAll(mainVBox, tabPane);
		
		//set the content to the hbox and set the title
		this.setContent(mainHBox);
		this.setText("Project Overview");
		this.setClosable(true);
	}

}
