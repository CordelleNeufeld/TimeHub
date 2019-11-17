/*
 * Database Access Object Class TaskHoursTable for TaskHourDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 */

package tables;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.TaskHourDAO;
import database.Const;
import javabeans.Task;
import javabeans.TaskHour;

public class TaskHoursTable implements TaskHourDAO {

	@Override
	public ArrayList<TaskHour> getAllTaskHours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskHour getTaskHour(int taskHourID) {
		// TODO Auto-generated method stub
		return null;
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
	public void deleteTaskHour(TaskHour taskHour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTaskHour(TaskHour taskHour) {
		// TODO Auto-generated method stub
		
	}

}
