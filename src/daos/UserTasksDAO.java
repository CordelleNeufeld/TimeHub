/*
 * Database Access Object: Many-to-Many Table
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-13
 */

package daos;

import java.util.ArrayList;

import javabeans.User;
import javabeans.Task;

public interface UserTasksDAO {
	
	public ArrayList<User> getUserTasks (int userID);
	
	public ArrayList<Task> getTaskUsers(int taskID);	

}
