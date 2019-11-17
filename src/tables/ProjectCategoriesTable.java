/*
 * Database Access Object Class ProjectCategoriesTable for ProjectCategoriesDAO
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-17
 */

package tables;

import java.util.ArrayList;

import daos.ProjectCategoriesDAO;
import javabeans.Category;
import javabeans.Project;

public class ProjectCategoriesTable implements ProjectCategoriesDAO {

	@Override
	public ArrayList<Category> getProjectCategories(int projectID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Project> getCategoryProjects(int categoryID) {
		// TODO Auto-generated method stub
		return null;
	}

}
