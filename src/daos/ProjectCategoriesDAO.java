/*
 * Database Access Object: Many-to-Many Table
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-13
 */

package daos;

import java.util.ArrayList;

import javabeans.Category;
import javabeans.Project;

public interface ProjectCategoriesDAO {
	
	public ArrayList<Category> getProjectCategories(int projectID);
	
	public ArrayList<Project> getCategoryProjects(int categoryID);	

}
