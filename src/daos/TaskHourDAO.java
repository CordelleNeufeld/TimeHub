/*
 * Database Access Object
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-13
 */

package daos;

import java.util.ArrayList;

import javabeans.Task;
import javabeans.TaskHour;



public interface TaskHourDAO {
	
	public ArrayList<TaskHour> getAllTaskHours();
	public TaskHour getTaskHour(int taskHourID);
	public void updateTaskHour(TaskHour taskHour, Task task);
	public void deleteTaskHour(TaskHour taskHour);
	public void createTaskHour(TaskHour taskHour);
	
}