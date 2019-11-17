/*
 * Database Access Object
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-13
 */

package daos;

import java.util.ArrayList;

import javabeans.User;

public interface UserDAO {
	
	public ArrayList<User> getAllUsers();
	public User getUser(int userID);
	public void updateUser(User user);
	public void deleteUser(User user);
	public void createUser(User user);
	
}
