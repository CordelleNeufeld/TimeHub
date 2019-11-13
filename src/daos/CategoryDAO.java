/*
 * Database Access Object
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-13
 */

package daos;

import java.util.ArrayList;

import javabeans.Category;

public interface CategoryDAO {
	
	public ArrayList<Category> getAllCategories();
	public Category getCategory(int categoryID);
	public void updateCategory(Category category);
	public void deleteCategory(Category category);
	public void createCategory(Category category);
	
}
