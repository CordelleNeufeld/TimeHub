package tabs;

import javabeans.Project;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import panes.TabsPane;

public class ProjectOverviewTab extends Tab {

    public ProjectOverviewTab(Project project) {

        //Create Form Fields
        Text projectName = new Text(project.getTitle());
        projectName.setFont(Font.font("Courier New",FontWeight.BOLD, 30));
        
        TextArea projectDesc = new TextArea(project.getDescription());
        projectDesc.setEditable(false);
        
        Button addTask = new Button("Add Task");
                
        addTask.setOnAction(e -> {
        	TaskFormTab taskForm = new TaskFormTab(null, project.getId());
        	TabsPane.tabPane.getTabs().add(taskForm);
        	TabsPane.tabPane.getTabs().remove(TabsPane.tabPane.getSelectionModel().getSelectedIndex());
        	TabsPane.tabPane.getSelectionModel().select(taskForm);
        });
        
        //Create the LeftVBox
        VBox leftVBox = new VBox(30);
        leftVBox.getChildren().addAll(projectName, projectDesc, addTask);
        leftVBox.setAlignment(Pos.CENTER);

        //Create MainHBox
        HBox mainHBox = new HBox(30);
        mainHBox.getChildren().addAll(leftVBox);
        mainHBox.setAlignment(Pos.CENTER);

        //Set Content and Styling of the Tab
        setContent(mainHBox);
        setText("Project Overview");
        setClosable(true);
    }
}