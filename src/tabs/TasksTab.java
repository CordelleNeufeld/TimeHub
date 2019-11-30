/*
 * Delete Tab
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-24
 */

package tabs;

import javabeans.Project;
import javabeans.Task;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import panes.TabsPane;
import tables.ProjectsTable;
import tables.TasksTable;

import java.util.ArrayList;
import java.util.HashMap;

public class TasksTab extends Tab {

    private static TasksTab tab;

    public TableView tableView;

    private TasksTab() {
        this.setText("Tasks");

        TasksTable taskViewTable = new TasksTable();
        ProjectsTable projectViewTable = new ProjectsTable();

        // gather projects and categories

        ArrayList<Project> projects = new ProjectsTable().getAllProjects();

        HashMap<Integer, Project> hashProjects = new HashMap<>();

        for (Project project : projects) {
            hashProjects.put(project.getId(), project);
        }

        BorderPane root = new BorderPane();

        tableView = new TableView();

        // COLUMN #1: Task Title
        TableColumn<Task, String> column1 = new TableColumn<>("Task Name");
        column1.setCellValueFactory(e -> new SimpleStringProperty(
                taskViewTable.getTask(e.getValue().getId()).getTitle()));

        tableView.getColumns().add(column1);

        // COLUMN #2: Task Description
        TableColumn<Task, String> column2 = new TableColumn<>("Description");
        column2.setCellValueFactory(e -> new SimpleStringProperty(
                taskViewTable.getTask(e.getValue().getId()).getDescription()));

        tableView.getColumns().add(column2);

        // COLUMN #3: Task Hours
        TableColumn<Task, Double> column3 = new TableColumn<>("Hour Log");
        column3.setCellValueFactory(e -> new SimpleDoubleProperty(
                taskViewTable.getTask(e.getValue().getId()).getHours()).asObject());

        tableView.getColumns().add(column3);

        // COLUMN #4: Project Title
        TableColumn<Task, String> column4 = new TableColumn<>("Project Name");
        column4.setCellValueFactory(e -> {
            String value = "No Project Assigned";
            if (hashProjects.get(e.getValue().getProjectId()) != null) {
                value = hashProjects.get(e.getValue().getProjectId()).getTitle();
            }
            return new SimpleStringProperty(value);
        });

        tableView.getColumns().add(column4);

        // COLUMN #5: Category Title
        TableColumn<Task, String> column5 = new TableColumn<>("Category Name");
        column5.setCellValueFactory(e -> {
            String value = "No Category Assigned";
            if (hashProjects.get(e.getValue().getProjectId()) != null) {
                value = hashProjects.get(e.getValue().getProjectId()).getCategories().get(0).getTitle();
            }
            return new SimpleStringProperty(value);
        });

        tableView.getColumns().add(column5);

        // display table

        tableView.getItems().addAll(taskViewTable.getAllTasks());

        root.setCenter(tableView);
        Button deleteButton = new Button("Delete Task");
        deleteButton.setOnAction(e -> {

            Task task = (Task) tableView.getSelectionModel().getSelectedItem();
            taskViewTable.deleteTask(task);

            // regenerate the table view
            refreshTable();

            // TODO: Statistics
            // StatsTab.getInstance().generateChart();

        });

        Button addTaskButton = new Button("Add Task");

        addTaskButton.setOnAction(e -> {
            TaskFormTab formTab = new TaskFormTab(-1);
            TabsPane.tabPane.getTabs().add(formTab);
            TabsPane.tabPane.getSelectionModel().select(formTab);
        });

        HBox groupButtons = new HBox(25);
        groupButtons.getChildren().addAll(addTaskButton, deleteButton);

        root.setBottom(groupButtons);

        this.setContent(root);
        this.setClosable(false);

    } // end of method: DeleteTab()

    public void refreshTable() {
        TasksTable table = new TasksTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.getAllTasks());

    } // end of method: refreshTable()

    public static TasksTab getInstance() {
        if (tab == null) {
            tab = new TasksTab();
        }
        return tab;

    } // end of method: DeleteTab getInstance()

} // end of class: DeleteTab