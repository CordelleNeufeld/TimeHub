/*
 * Database Access Object Class CategoriesTable for CategoryDAO
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
import daos.CategoryDAO;
import database.Const;
import javabeans.Category;

public class CategoriesTable implements CategoryDAO {
	
	Database db = Database.getInstance();
	ArrayList<Category> categories;

	@Override
	public ArrayList<Category> getAllCategories() {
		String query = "SELECT * FROM " + Const.TABLE_CATEGORIES;
		categories = new ArrayList<Category>();
		
		try {
			Statement getCategories = db.getConnection().createStatement();
			ResultSet data = getCategories.executeQuery(query);
			
			while(data.next()) {
				categories.add(new Category(data.getInt(Const.CATEGORIES_COLUMN_ID),
						data.getString(Const.CATEGORIES_COLUMN_TITLE),
						data.getString(Const.CATEGORIES_COLUMN_DESCRIPTION)
						));
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categories;
		
	}

	@Override
	public Category getCategory(int categoryID) {
		String query = "SELECT * FROM " + Const.TABLE_CATEGORIES + " WHERE " + Const.CATEGORIES_COLUMN_ID + " = " + categoryID;
        Category category = null;
        try {
            Statement getCategory = db.getConnection().createStatement();
            ResultSet data = getCategory.executeQuery(query);
            
            while(data.next()) {
                category = new Category(data.getInt(Const.CATEGORIES_COLUMN_ID),
						data.getString(Const.CATEGORIES_COLUMN_TITLE),
						data.getString(Const.CATEGORIES_COLUMN_DESCRIPTION)
						);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
	}

	@Override
	public void updateCategory(Category category) {	
		String query = "UPDATE " + Const.TABLE_CATEGORIES + " SET " +
				Const.CATEGORIES_COLUMN_TITLE + " " + category.getTitle() + "," +
				Const.CATEGORIES_COLUMN_DESCRIPTION + " " + category.getDescription() + 
				" WHERE " + Const.CATEGORIES_COLUMN_ID + " = " + category.getId();
			try {
				Statement updateCategory = db.getConnection().createStatement();
				updateCategory.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteCategory(Category category) {
		String query  = "DELETE FROM " + Const.TABLE_CATEGORIES + " WHERE " +
				Const.CATEGORIES_COLUMN_ID + " = " + category.getId();
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Deleted category");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createCategory(Category category) {
		String query = "INSERT INTO " + Const.TABLE_CATEGORIES +
				"(" + Const.CATEGORIES_COLUMN_TITLE + ", " +
				Const.CATEGORIES_COLUMN_DESCRIPTION + ") VALUES ('" +
				category.getTitle() + "','" + category.getDescription() + "')";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Inserted Category");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
