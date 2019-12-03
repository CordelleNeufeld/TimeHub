/*
 * Database Access Object Class TasksTable for TaskDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 * Initial CRUD: Cordelle - Retrieve (get/getAll) and Hasan - Update
 * Modification Date: 2019-11-22
 * CRUD Completion: Hasan - Create and Cordelle - Delete
 */

package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Database;
import daos.TaskDAO;
import database.Const;
import javabeans.Task;

public class TasksTable implements TaskDAO {
	
	Database db = Database.getInstance();
	ArrayList<Task> tasks;

	@Override
	public ArrayList<Task> getAllTasks() {
		String query = "SELECT * FROM " + Const.TABLE_TASKS;
		tasks = new ArrayList<>();
		
		try {
			Statement getTasks = db.getConnection().createStatement();
			ResultSet data = getTasks.executeQuery(query);
			
			while(data.next()) {
				tasks.add(new Task(data.getInt(Const.TASKS_COLUMN_ID),
						data.getString(Const.TASKS_COLUMN_TITLE),
						data.getString(Const.TASKS_COLUMN_DESCRIPTION),
						data.getString(Const.TASKS_COLUMN_DATE),
						data.getDouble(Const.TASKS_COLUMN_HOURS),
						data.getInt(Const.TASKS_COLUMN_PROJECT_ID)
						));
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tasks;
		
	}

	@Override
	public Task getTask(int taskID) {
		String query = "SELECT * FROM " + Const.TABLE_TASKS + " WHERE " + Const.TASKS_COLUMN_ID + " = " + taskID;
        Task task = null;
        try {
            Statement getTask = db.getConnection().createStatement();
            ResultSet data = getTask.executeQuery(query);
            
            while(data.next()) {
                task = new Task(data.getInt(Const.TASKS_COLUMN_ID),
						data.getString(Const.TASKS_COLUMN_TITLE),
						data.getString(Const.TASKS_COLUMN_DESCRIPTION),
						data.getString(Const.TASKS_COLUMN_DATE),
						data.getDouble(Const.TASKS_COLUMN_HOURS),
						data.getInt(Const.TASKS_COLUMN_PROJECT_ID)
						);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
	}

	@Override
	public void updateTask(Task task) {
		String query = "UPDATE " + Const.TABLE_TASKS + " SET " +
				Const.TASKS_COLUMN_TITLE + " = '" + task.getTitle() + "', " +
				Const.TASKS_COLUMN_DESCRIPTION + " = '" + task.getDescription() + "', " +
				Const.TASKS_COLUMN_HOURS + " = '" + task.getHours() + "', " +
				Const.TASKS_COLUMN_DATE + " = '" + task.getDate() +
				"' WHERE " + Const.TASKS_COLUMN_ID + " = " + task.getId();
				
			try {
				db.getConnection().createStatement().execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteTask(Task task) {
		String query  = "DELETE FROM " + Const.TABLE_TASKS + " WHERE " +
				Const.TASKS_COLUMN_ID + " = " + task.getId();
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Deleted task");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void createTask(Task task) {

		String query = "INSERT INTO " + Const.TABLE_TASKS +
				"(" + Const.TASKS_COLUMN_TITLE + ", " +
				Const.TASKS_COLUMN_DESCRIPTION + ", " +
				Const.TASKS_COLUMN_HOURS + ", " +
				Const.TASKS_COLUMN_DATE + ", " +
				Const.TASKS_COLUMN_PROJECT_ID + ") VALUES ('" +
				task.getTitle() + "','" + task.getDescription() + "','" +
				task.getHours() + "','" + task.getDate() + "',";

		if(task.getProjectId() == -1) {
			query += "NULL)";
		} else {
			query += "'" + task.getProjectId() + "')";
		}
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Inserted Task");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public double getAllHours(int projectId) {
		
		String query = "SELECT SUM(hours) FROM " + Const.TABLE_TASKS +
				" WHERE " + Const.TASKS_COLUMN_PROJECT_ID + " = " +
				projectId;
		
		double hours = 0.0;
		
		try {
			Statement statement = Database.getInstance().getConnection().createStatement();
			ResultSet data = statement.executeQuery(query);
			
			while(data.next()) {
				hours = data.getDouble("SUM(hours)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hours;
	}

}
