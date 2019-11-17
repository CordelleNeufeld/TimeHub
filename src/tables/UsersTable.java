/*
 * Database Access Object Class UsersTable for UserDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 */

package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Database;
import daos.UserDAO;
import database.Const;
import javabeans.Task;
import javabeans.User;

public class UsersTable implements UserDAO {
	
	Database db = Database.getInstance();
	ArrayList<User> users;

	@Override
	public ArrayList<User> getAllUsers() {
		
		String query = "SELECT * FROM " + Const.TABLE_USERS;
		users = new ArrayList<User>();
		
		try {
			Statement getUsers = db.getConnection().createStatement();
			ResultSet data = getUsers.executeQuery(query);
			
			while(data.next()) {
				users.add(new User(data.getInt(Const.USERS_COLUMN_ID),
						data.getString(Const.USERS_COLUMN_NAME_FIRST),
						data.getString(Const.USERS_COLUMN_NAME_LAST),
						data.getString(Const.USERS_COLUMN_LAST_ACCESSED),
						// placeholder
						new ArrayList<>()));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
		
	}

	@Override
	public User getUser(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
