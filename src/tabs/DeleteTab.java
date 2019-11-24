/*
 * Delete Tab
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-24
 */

package tabs;

import javabeans.Task;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import tables.CategoriesTable;
import tables.ProjectsTable;
import tables.TasksTable;

public class DeleteTab extends Tab {
	
	private static DeleteTab tab;
	
	public TableView tableView;
	
	private DeleteTab() {
		this.setText("Delete");

		TasksTable taskViewTable = new TasksTable();
		ProjectsTable projectViewTable = new ProjectsTable();
		CategoriesTable categoryViewTable = new CategoriesTable();
		
		BorderPane root = new BorderPane();
		
		tableView = new TableView();
		
		// COLUMN #1: Task Title
		TableColumn<Task, String> column1 = new TableColumn<>("Task Name");
		column1.setCellValueFactory(e -> new SimpleStringProperty(
				taskViewTable.getTask(e.getValue().getId()).getTitle()));
		
		tableView.getColumns().add(column1);
		
		
		// COLUMN #2: Task Description
		
		// COLUMN #3: Task Hours
		
		// COLUMN #4: Project Title
		
		// COLUMN #5: Category Title
		
		// display table
		
		tableView.getItems().addAll(taskViewTable.getAllTasks());
		
		root.setCenter(tableView);
		Button deleteButton = new Button ("Delete Task");
		deleteButton.setOnAction(e-> {
			
			Task task = (Task) tableView.getSelectionModel().getSelectedItem();
			taskViewTable.deleteTask(task);
			
			// regenerate the table view
			refreshTable();

			// TODO: Statistics
			// StatsTab.getInstance().generateChart();
			
		});
		
		root.setBottom(deleteButton);
		
		this.setContent(root);
		
	} // end of method: DeleteTab()
	
	public void refreshTable() {
		TasksTable table = new TasksTable();
		tableView.getItems().clear();
		tableView.getItems().addAll(table.getAllTasks());
	
	} // end of method: refreshTable()

	public static DeleteTab getInstance() {
		if(tab == null) {
			tab = new DeleteTab();
		}
		return tab;
	
	} // end of method: DeleteTab getInstance()
	
} // end of class: RemoveTab