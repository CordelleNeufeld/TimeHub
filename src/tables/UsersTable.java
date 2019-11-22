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
						
						// TODO placeholder
						new ArrayList<>()));
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
		
	}

	@Override
	public User getUser(int userID) {
		String query = "SELECT * FROM " + Const.TABLE_USERS + " WHERE " + Const.USERS_COLUMN_ID + " = " + userID;
        User user = null;
        try {
            Statement getUser = db.getConnection().createStatement();
            ResultSet data = getUser.executeQuery(query);
            
            while(data.next()) {
                user = new User(data.getInt(Const.USERS_COLUMN_ID),
                		data.getString(Const.USERS_COLUMN_NAME_FIRST),
						data.getString(Const.USERS_COLUMN_NAME_LAST),
						data.getString(Const.USERS_COLUMN_LAST_ACCESSED),
						
						// TODO placeholder
						new ArrayList<>());
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
	}

	@Override
	public void updateUser(User user) {
		String query = "UPDATE " + Const.TABLE_USERS + " SET " +
				Const.USERS_COLUMN_NAME_FIRST + " " + user.getFirstName() + "," +
				Const.USERS_COLUMN_NAME_LAST + " " + user.getLastName() + "," +
				Const.USERS_COLUMN_LAST_ACCESSED + " " + user.getLastAccessed() +
				" WHERE " + Const.USERS_COLUMN_ID + " = " + user.getId();
			try {
				Statement updateUser = db.getConnection().createStatement();
				updateUser.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(User user) {
		String query = "INSERT INTO " + Const.TABLE_USERS +
				"(" + Const.USERS_COLUMN_NAME_FIRST + ", " +
				Const.USERS_COLUMN_NAME_LAST + ", " +
				Const.USERS_COLUMN_LAST_ACCESSED + ") VALUES ('" +
				user.getFirstName() + "','" + user.getLastName() + "','" +
				user.getLastAccessed() + "')";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Inserted User");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
