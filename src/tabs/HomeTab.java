/*
 * Provide the user with a home screen
 *
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

package tabs;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import panes.TabsPane;
import tables.CategoriesTable;
import tables.ProjectsTable;
import tables.TasksTable;

import java.util.ArrayList;

public class HomeTab extends Tab {

    private static HomeTab instance = null;

    private HomeTab() {

        //Create Buttons for different Tabs
        Button categoriesButton = new Button("Categories");
        Button projectsButton = new Button("Projects");
        Button tasksButton = new Button("Tasks");
        
        //Make the tables
        CategoriesTable categoryTable = new CategoriesTable();
        ProjectsTable projectTable = new ProjectsTable();
        TasksTable taskTable = new TasksTable();

        //OnClickListeners to show the new tabs
        categoriesButton.setOnAction(e -> {
            CategoriesTab category = CategoriesTab.getInstance(categoryTable.getAllCategories());
            TabsPane.tabPane.getTabs().add(category);
            TabsPane.tabPane.getSelectionModel().select(category);
        });

        projectsButton.setOnAction(e -> {
            ProjectsTab project = ProjectsTab.getInstance(projectTable.getAllProjects());
            TabsPane.tabPane.getTabs().add(project);
            TabsPane.tabPane.getSelectionModel().select(project);
        });

        tasksButton.setOnAction(e -> {
            HourLogsTab hourLogs = HourLogsTab.getInstance(taskTable.getAllTasks());
            TabsPane.tabPane.getTabs().add(hourLogs);
            TabsPane.tabPane.getSelectionModel().select(hourLogs);
        });

        //Create VBox to hold the Buttons
        VBox buttonsVBox = new VBox(50);
        buttonsVBox.getChildren().addAll(categoriesButton, projectsButton, tasksButton);
        buttonsVBox.setAlignment(Pos.CENTER);

        //Set Content and Styles for the Tab
        setContent(buttonsVBox);
        setText("Home");
        setClosable(false);
    }

    public static HomeTab getInstance() {
        if (instance == null) {
            instance = new HomeTab();
        }

        return instance;
    }
}