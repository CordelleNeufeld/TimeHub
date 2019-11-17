/*
 * Database Access Object
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-13
 */

package daos;

import java.util.ArrayList;

import javabeans.Task;

public interface TaskDAO {
	
	public ArrayList<Task> getAllTasks();
	public Task getTask(int taskID);
	public void updateTask(Task task);
	public void deleteTask(Task task);
	public void createTask(Task task);
	
}
