package tabs;

import classes.ProjectButton;
import javabeans.Project;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import panes.TabsPane;
import tables.ProjectsTable;

import java.util.ArrayList;

public class ProjectsTab extends Tab {

    private static ProjectsTab instance = null;

    private ProjectsTab() {

        ArrayList<Project> projects = new ProjectsTable().getAllProjects();
        
        ImageView projImage = new ImageView(new Image("resources/sundial_nav_400_280.png"));
        projImage.setFitWidth(240);
        projImage.setFitHeight(168);

        //Title
        Text projectsTitle = new Text("Projects");
        projectsTitle.setFont(Font.font("Courier New",FontWeight.BOLD, 30));
        projectsTitle.setTextAlignment(TextAlignment.CENTER);

        //New Project Button
        Button newProjectButton = new Button("Add Project");

        newProjectButton.setOnAction(e -> {
            ProjectFormTab formTab = new ProjectFormTab();
            TabsPane.tabPane.getTabs().add(formTab);
            TabsPane.tabPane.getSelectionModel().select(formTab);
        });
        
        ListView<Project> projectsList = new ListView<>();
        projectsList.setMaxWidth(500);
        projectsList.setMaxHeight(300);
        
        for(Project project : projects) {
        		projectsList.getItems().add(project);
        }
        
        //set on click for listview to navigate to the select project's overview screen
        projectsList.getSelectionModel().selectedItemProperty().addListener(e -> {
        	ProjectOverviewTab overviewTab = new ProjectOverviewTab(projectsList.getSelectionModel().getSelectedItem());
			TabsPane.tabPane.getTabs().add(overviewTab);
			TabsPane.tabPane.getSelectionModel().select(overviewTab);
        });

        //Set up VBox
        VBox mainPane = new VBox();
        mainPane.getChildren().addAll(projImage, projectsTitle, projectsList, newProjectButton);
        mainPane.setAlignment(Pos.TOP_CENTER);
        mainPane.setSpacing(45);
        mainPane.setPadding(new Insets(20, 0, 0, 0));

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