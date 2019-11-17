/*
 * Database Access Object Class UserTasksTable for UserTasksDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 */

package tables;

import java.util.ArrayList;

import daos.UserTasksDAO;
import javabeans.Task;
import javabeans.User;

public class UserTasksTable implements UserTasksDAO {

	@Override
	public ArrayList<User> getUserTasks(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Task> getTaskUsers(int taskID) {
		// TODO Auto-generated method stub
		return null;
	}

}
