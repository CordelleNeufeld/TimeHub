package tabs;

import classes.ProjectButton;
import javabeans.Project;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class ProjectsTab extends Tab {

    public ProjectsTab(ArrayList<Project> projects, TabPane tabPane) {

        //Title
        Text projectsTitle = new Text("Projects");
        projectsTitle.setTextAlignment(TextAlignment.CENTER);

        //Set up the List View
        ListView<ProjectButton> buttonListView = new ListView<>();

        for (Project project: projects) {
            ProjectButton projectButton = new ProjectButton(project.getTitle(), project);

            projectButton.setOnAction(event -> {
                Tab projectTab = new ProjectOverviewTab(((ProjectButton) event.getSource()).getProject());
                tabPane.getTabs().add(projectTab);

            });

            buttonListView.getItems().add(projectButton);
        }

        //New Project Button


        //Set up borderPane
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(projectsTitle);
        mainPane.setCenter(buttonListView);

        //Add content to Tab
        setContent(mainPane);
        setText("Projects");
    }
}