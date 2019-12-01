package tabs;

import javabeans.Project;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import panes.TabsPane;

public class ProjectOverviewTab extends Tab {

    public ProjectOverviewTab(Project project) {

        //Create Form Fields
        Text projectName = new Text(project.getTitle());
        TextArea projectDesc = new TextArea(project.getDescription());
        Button addProject = new Button("Add Project");
        Button addTask = new Button("Add Task");
        
        addProject.setOnAction(e -> TabsPane.tabPane.getTabs().add(new ProjectFormTab()));
        
        addTask.setOnAction(e -> TabsPane.tabPane.getTabs().add(new TaskFormTab(null, project.getId())));

        HBox buttonsHBox = new HBox(20);
        buttonsHBox.getChildren().addAll(addProject, addTask);
        
        //Create the LeftVBox
        VBox leftVBox = new VBox(30);
        leftVBox.getChildren().addAll(projectName, projectDesc, buttonsHBox);

        //Create MainHBox
        HBox mainHBox = new HBox(30);
        mainHBox.getChildren().addAll(leftVBox);

        //Set Content and Styling of the Tab
        setContent(mainHBox);
        setText("Project Overview");
        setClosable(true);
    }
}