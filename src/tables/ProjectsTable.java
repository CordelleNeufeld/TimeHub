/*
 * Database Access Object Class ProjectsTable for ProjectDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 * Initial CRUD: Cordelle - Retrieve (get/getAll) and Hasan - Update
 * Modification Date: 2019-11-22
 * CRUD Completion: Hasan - Create and Cordelle - Delete
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
		ProjectCategoriesTable projectCategories = new ProjectCategoriesTable();
		
		try {
			Statement getProjects = db.getConnection().createStatement();
			ResultSet data = getProjects.executeQuery(query);
			
			while(data.next()) {
				
				int projectID = data.getInt(Const.PROJECTS_COLUMN_ID);
				
				projects.add(new Project(projectID,
						
						projectCategories.getProjectCategories(projectID),
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
            Statement getProject = db.getConnection().createStatement();
            ResultSet data = getProject.executeQuery(query);
            
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
		String query = "UPDATE " + Const.TABLE_PROJECTS + " SET " +
				Const.PROJECTS_COLUMN_TITLE + " " + project.getTitle() + "," +
				Const.PROJECTS_COLUMN_DESCRIPTION + " " + project.getDescription() + 
				" WHERE " + Const.PROJECTS_COLUMN_ID + " = " + project.getId();
			try {
				Statement updateProject = db.getConnection().createStatement();
				updateProject.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

	@Override
	public void deleteProject(Project project) {
		String query  = "DELETE FROM " + Const.TABLE_PROJECTS + " WHERE " +
				Const.PROJECTS_COLUMN_ID + " = " + project.getId();
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Deleted project");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void createProject(Project project) {	
		String query = "INSERT INTO " + Const.TABLE_PROJECTS +
				"(" + Const.PROJECTS_COLUMN_TITLE + ", " +
				Const.PROJECTS_COLUMN_DESCRIPTION + ") VALUES ('" +
				project.getTitle() + "','" + project.getDescription() + "')";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Inserted Project");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
