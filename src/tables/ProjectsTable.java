/*
 * Database Access Object Class ProjectsTable for ProjectDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 */

package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Database;
import daos.ProjectDAO;
import database.Const;
import javabeans.Project;
import javabeans.User;

public class ProjectsTable implements ProjectDAO {
	
	Database db = Database.getInstance();
	ArrayList<Project> projects;

	@Override
	public ArrayList<Project> getAllProjects() {
		
		String query = "SELECT * FROM " + Const.TABLE_PROJECTS;
		projects = new ArrayList<Project>();
		
		try {
			Statement getProjects = db.getConnection().createStatement();
			ResultSet data = getProjects.executeQuery(query);
			
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
	public Project getProject(int projectID) {
		String query = "SELECT * FROM " + Const.TABLE_USERS + " WHERE " + Const.USERS_COLUMN_ID + " = " + userID;
        User user = null;
        try {
            Statement getConditions = db.getConnection().createStatement();
            ResultSet data = getConditions.executeQuery(query);
            
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
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createProject(Project project) {
		// TODO Auto-generated method stub
		
	}

}
