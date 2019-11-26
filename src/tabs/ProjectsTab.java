package tabs;

import classes.ProjectButton;
import javabeans.Project;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import panes.TabsPane;

import java.util.ArrayList;

public class ProjectsTab extends Tab {

    private static ProjectsTab instance = null;

    private ProjectsTab(ArrayList<Project> projects) {

        //Title
        Text projectsTitle = new Text("Projects");
        projectsTitle.setTextAlignment(TextAlignment.CENTER);

        //Set up the List View
        ListView<ProjectButton> buttonListView = new ListView<>();

        for (Project project : projects) {
            ProjectButton projectButton = new ProjectButton(project.getTitle(), project);

            projectButton.setOnAction(event -> {
                Tab projectTab = new ProjectOverviewTab(((ProjectButton) event.getSource()).getProject());
                TabsPane.tabPane.getTabs().add(projectTab);

            });

            buttonListView.getItems().add(projectButton);
        }

        //New Project Button
        Button newProjectButton = new Button("Add Project");
        
        newProjectButton.setOnAction(e -> TabsPane.tabPane.getTabs().add(new ProjectFormTab()));

        //Set up borderPane
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(projectsTitle);
        mainPane.setCenter(buttonListView);
        mainPane.setBottom(newProjectButton);

        //Add content to Tab
        setContent(mainPane);
        setText("Projects");
        this.setClosable(true);
    }

    public static ProjectsTab getInstance(ArrayList<Project> projects) {
        if (instance == null) {
            instance = new ProjectsTab(projects);
        }
        return instance;
    }
}