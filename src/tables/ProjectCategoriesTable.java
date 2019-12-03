/*
 * Database Access Object Class ProjectCategoriesTable for ProjectCategoriesDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 * 
 * Modified by Hasan, Abel, and Cordelle on 2019-11-27
 * 
 */

package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import classes.Database;
import daos.ProjectCategoriesDAO;
import database.Const;
import javabeans.Category;
import javabeans.Project;

public class ProjectCategoriesTable implements ProjectCategoriesDAO {

	@Override
	public ArrayList<Category> getProjectCategories(int projectID) {
		String query = "SELECT * FROM " + Const.TABLE_CATEGORIES
				+ " INNER JOIN " + Const.TABLE_PROJECT_CATEGORIES + " ON "
				+ Const.TABLE_CATEGORIES + "." + Const.CATEGORIES_COLUMN_ID + " = "
				+ Const.TABLE_PROJECT_CATEGORIES + "." + Const.PROJECT_CATEGORIES_COLUMN_CAT_ID
				+ " WHERE " + Const.TABLE_PROJECT_CATEGORIES + "." + Const.PROJECT_CATEGORIES_COLUMN_PROJECT_ID
				+ " = " + projectID;
		
		ArrayList<Category> categories = new ArrayList<Category>();
		
		try {
			Statement statement = Database.getInstance().getConnection().createStatement();
			ResultSet data = statement.executeQuery(query);
			
			while(data.next()) {
				categories.add(new Category(data.getInt(Const.CATEGORIES_COLUMN_ID), 
								data.getString(Const.CATEGORIES_COLUMN_TITLE), 
								data.getString(Const.CATEGORIES_COLUMN_DESCRIPTION)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categories;
		
	}

	@Override
	public ArrayList<Project> getCategoryProjects(int categoryID) {
			
		String query = "SELECT * FROM " + Const.TABLE_PROJECTS
				+ " INNER JOIN " + Const.TABLE_PROJECT_CATEGORIES + " ON "
				+ Const.TABLE_PROJECTS + "." + Const.PROJECTS_COLUMN_ID + " = "
				+ Const.TABLE_PROJECT_CATEGORIES + "." + Const.PROJECT_CATEGORIES_COLUMN_PROJECT_ID
				+ " WHERE " + Const.TABLE_PROJECT_CATEGORIES + "." + Const.PROJECT_CATEGORIES_COLUMN_CAT_ID
				+ " = " + categoryID;
		
		ArrayList<Project> projects = new ArrayList<Project>();
		
		try {
			Statement statement = Database.getInstance().getConnection().createStatement();
			ResultSet data = statement.executeQuery(query);
			
			while(data.next()) {
				projects.add(new Project(data.getInt(Const.PROJECTS_COLUMN_ID), 
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
	
	public void insertProjectCategory(int catId, int projId) {
		String query = "INSERT INTO " + Const.TABLE_PROJECT_CATEGORIES + " VALUES ('" + projId + "', '" + catId + "')";
		
		try {
			Database.getInstance().getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
