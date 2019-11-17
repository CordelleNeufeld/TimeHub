/*
 * Database Access Object Class TaskHoursTable for TaskHourDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 */

package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Database;
import daos.TaskHourDAO;
import database.Const;
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
	public void updateTaskHour(TaskHour taskHour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTaskHour(TaskHour taskHour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTaskHour(TaskHour taskHour) {
		// TODO Auto-generated method stub
		
	}

}
