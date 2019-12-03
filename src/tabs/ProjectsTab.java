package tabs;

import classes.ProjectButton;
import javabeans.Project;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import panes.TabsPane;
import tables.ProjectsTable;

import java.util.ArrayList;

public class ProjectsTab extends Tab {

    private static ProjectsTab instance = null;

    private ProjectsTab() {

        ArrayList<Project> projects = new ProjectsTable().getAllProjects();

        //Title
        Text projectsTitle = new Text("Projects");
        projectsTitle.setTextAlignment(TextAlignment.CENTER);

        //Set up the List View
//        ListView<ProjectButton> buttonListView = new ListView<>();
//        buttonListView.setMaxWidth(600);
//        buttonListView.setMaxHeight(500);
//
//        for (Project project : projects) {
//            ProjectButton projectButton = new ProjectButton(project.getTitle(), project);
//
//            projectButton.setOnAction(event -> {
//                Tab projectTab = new ProjectOverviewTab(((ProjectButton) event.getSource()).getProject());
//                TabsPane.tabPane.getTabs().add(projectTab);
//                TabsPane.tabPane.getSelectionModel().select(projectTab);
//            });
//
//            buttonListView.getItems().add(projectButton);
//        }

        //New Project Button
        Button newProjectButton = new Button("Add Project");

        newProjectButton.setOnAction(e -> {
            ProjectFormTab formTab = new ProjectFormTab();
            TabsPane.tabPane.getTabs().add(formTab);
            TabsPane.tabPane.getSelectionModel().select(formTab);
        });
        
        ListView<Project> projectsList = new ListView<>();
        projectsList.setMaxWidth(600);
        projectsList.setMaxHeight(500);
        
        for(Project project : projects) {
        		projectsList.getItems().add(project);
        }
        
        //set on click for listview to navigate to the select project's overview screen
        projectsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Project>() {

			@Override
			public void changed(ObservableValue<? extends Project> observable, Project oldValue, Project newValue) {
				ProjectOverviewTab overviewTab = new ProjectOverviewTab(newValue);
				TabsPane.tabPane.getTabs().add(overviewTab);
				TabsPane.tabPane.getSelectionModel().select(overviewTab);
			}
        	
        });

        //Set up VBox
        VBox mainPane = new VBox();
        mainPane.getChildren().addAll(projectsTitle, projectsList, newProjectButton);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setSpacing(100);

        //Add content to Tab
        setContent(mainPane);
        setText("Projects");
        setClosable(false);
    }

    public static ProjectsTab getInstance() {
        if (instance == null) {
            instance = new ProjectsTab();
        }
        return instance;
    }

    public static ProjectsTab refresh() {
        instance = new ProjectsTab();
        return instance;
    }
}