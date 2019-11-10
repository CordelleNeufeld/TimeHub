package panes;

import javabeans.Project;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ProjectOverview extends Tab{
	
	public ProjectOverview(Project project) {
		
		VBox mainVBox = new VBox(30);
		
		Text projectName = new Text("Title");
		
		TextArea projectDesc = new TextArea("Description");
		
		Button addProject = new Button("Add Project");
		
		mainVBox.getChildren().addAll(projectName, projectDesc, addProject);
		
		HBox mainHBox = new HBox(30);
		
		TabPane tabPane = new TabPane();
		
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		tabPane.getTabs().addAll(new Tab("Tab 1"), new Tab("Tab 2"));
		
		mainHBox.getChildren().addAll(mainVBox, tabPane);
		
		this.setContent(mainHBox);
		this.setText("Project Overview");
	}

}
