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
				projects.add(new Project(data.getInt(Const.PROJECTS_COLUMN_ID),
						
						// TODO placeholders
						new ArrayList<>(),
						new ArrayList<>(),
						
						data.getString(Const.PROJECTS_COLUMN_TITLE),
						data.getString(Const.PROJECTS_COLUMN_DESCRIPTION)));
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return projects;
		
	}

	@Override
	public Project getProject(int projectID) {
		String query = "SELECT * FROM " + Const.TABLE_PROJECTS + " WHERE " + Const.PROJECTS_COLUMN_ID + " = " + projectID;
        Project project = null;
        try {
            Statement getConditions = db.getConnection().createStatement();
            ResultSet data = getConditions.executeQuery(query);
            
            while(data.next()) {
                project = new Project(data.getInt(Const.PROJECTS_COLUMN_ID),
						
						// TODO placeholders
						new ArrayList<>(),
						new ArrayList<>(),
						
						data.getString(Const.PROJECTS_COLUMN_TITLE),
						data.getString(Const.PROJECTS_COLUMN_DESCRIPTION));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
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
