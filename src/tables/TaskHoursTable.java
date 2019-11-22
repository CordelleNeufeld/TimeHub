/*
 * Database Access Object Class TaskHoursTable for TaskHourDAO
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
import daos.TaskHourDAO;
import database.Const;
import javabeans.Task;
import javabeans.TaskHour;

public class TaskHoursTable implements TaskHourDAO {
	
	Database db = Database.getInstance();
	ArrayList<TaskHour> taskHours;

	@Override
	public ArrayList<TaskHour> getAllTaskHours() {
		
		String query = "SELECT * FROM " + Const.TABLE_TASK_HOURS;
		taskHours = new ArrayList<TaskHour>();
		
		try {
			Statement getTaskHours = db.getConnection().createStatement();
			ResultSet data = getTaskHours.executeQuery(query);
			
			while(data.next()) {
				taskHours.add(new TaskHour(data.getDate(Const.TASK_HOURS_COLUMN_DATE),
						data.getDouble(Const.TASK_HOURS_COLUMN_HOURS)));
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return taskHours;
		
	}

	@Override
	public TaskHour getTaskHour(int taskHourID) {
		String query = "SELECT * FROM " + Const.TABLE_TASK_HOURS + " WHERE " + Const.TASK_HOURS_COLUMN_TASK_ID + " = " + taskHourID;
        TaskHour taskHours = null;
        try {
            Statement getTaskHours = db.getConnection().createStatement();
            ResultSet data = getTaskHours.executeQuery(query);
            
            while(data.next()) {
                taskHours = new TaskHour(data.getDate(Const.TASK_HOURS_COLUMN_DATE),
						data.getDouble(Const.TASK_HOURS_COLUMN_HOURS));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskHours;
	}

	@Override
	public void updateTaskHour(TaskHour taskHour, Task task) {
		String query = "UPDATE " + Const.TABLE_TASK_HOURS + " SET " +
				Const.TASK_HOURS_COLUMN_HOURS + " " + taskHour.getHours() + "," +
				Const.TASK_HOURS_COLUMN_DATE + " " + taskHour.getDate() + 
				" WHERE " + Const.TASK_HOURS_COLUMN_TASK_ID + " = " + task.getId();
			try {
				Statement updateProject = db.getConnection().createStatement();
				updateProject.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteTaskHour(TaskHour taskHour, Task task) {
		String query  = "DELETE FROM " + Const.TABLE_TASK_HOURS + " WHERE " +
				Const.TASK_HOURS_COLUMN_TASK_ID + " = " + task.getId();
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Deleted task hour(s)");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void createTaskHour(TaskHour taskHour) {
		// TODO Auto-generated method stub
		
	}

}
