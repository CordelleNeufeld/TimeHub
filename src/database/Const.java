package database;

/*
 * Database constants and SQL creation queries
 * @author Cordelle Neufeld
 * Creation Date: 2019-11-10
 */

public class Const {
	
	// TASKS TABLE
	public static final String TABLE_TASKS = "tasks";
	public static final String TASKS_COLUMN_ID = "id";
	public static final String TASKS_COLUMN_PROJECT_ID = "project_id";
	public static final String TASKS_COLUMN_TITLE = "title";
	public static final String TASKS_COLUMN_DESCRIPTION = "description";
	public static final String TASKS_COLUMN_HOURS = "hours";
	public static final String TASKS_COLUMN_DATE = "date";

	// PROJECTS TABLE
	public static final String TABLE_PROJECTS = "projects";
	public static final String PROJECTS_COLUMN_ID = "id";
	public static final String PROJECTS_COLUMN_TITLE = "title";
	public static final String PROJECTS_COLUMN_DESCRIPTION = "description";
	
	// PROJECT CATEGORIES TABLE (MANY-TO-MANY)
	public static final String TABLE_PROJECT_CATEGORIES = "project_categories";
	public static final String PROJECT_CATEGORIES_COLUMN_PROJECT_ID = "project_id";
	public static final String PROJECT_CATEGORIES_COLUMN_CAT_ID = "cat_id";
	
	// CATEGORIES TABLE
	public static final String TABLE_CATEGORIES = "categories";
	public static final String CATEGORIES_COLUMN_ID = "id";
	public static final String CATEGORIES_COLUMN_TITLE = "title";
	public static final String CATEGORIES_COLUMN_DESCRIPTION = "description";
	
	// The following tables are included for extensibility
	
	// USERS TABLE
	public static final String TABLE_USERS = "users";
	public static final String USERS_COLUMN_ID = "id";
	public static final String USERS_COLUMN_NAME_FIRST = "name_first";
	public static final String USERS_COLUMN_NAME_LAST = "name_last";
	public static final String USERS_COLUMN_LAST_ACCESSED = "last_accessed";
	
	// USER TASKS TABLE (MANY-TO-MANY)
	public static final String TABLE_USER_TASKS = "user_tasks";
	public static final String USER_TASKS_COLUMN_USER_ID = "user_id";
	public static final String USER_TASKS_COLUMN_TASK_ID = "task_id";

	// ONE-TO-MANY x3 TABLE CREATION QUERIES
	// users, projects, and categories
	
	public static final String CREATE_TABLE_USERS =
			"CREATE TABLE " + TABLE_USERS + "(" +
			USERS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			USERS_COLUMN_NAME_FIRST + " VARCHAR(30), " +
			USERS_COLUMN_NAME_LAST + " VARCHAR(50), " +
			USERS_COLUMN_LAST_ACCESSED + " DATETIME, " +
			"PRIMARY KEY(" + USERS_COLUMN_ID + ")" +
			");";
	
	public static final String CREATE_TABLE_PROJECTS =
			"CREATE TABLE " + TABLE_PROJECTS + "(" +
			PROJECTS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			PROJECTS_COLUMN_TITLE + " VARCHAR(20), " +
			PROJECTS_COLUMN_DESCRIPTION + " VARCHAR(75), " +
			"PRIMARY KEY(" + PROJECTS_COLUMN_ID + ")" +
			");";
	
	public static final String CREATE_TABLE_CATEGORIES =
			"CREATE TABLE " + TABLE_CATEGORIES + "(" +
			CATEGORIES_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			CATEGORIES_COLUMN_TITLE + " VARCHAR(20), " +
			CATEGORIES_COLUMN_DESCRIPTION + " VARCHAR(75), " +
			"PRIMARY KEY(" + CATEGORIES_COLUMN_ID + ")" +
			");";
	
	// MANY-TO-MANY TABLE CREATION QUERIES x2 
	
	public static final String CREATE_TABLE_PROJECT_CATEGORIES =
			"CREATE TABLE " + TABLE_PROJECT_CATEGORIES + "(" +
			PROJECT_CATEGORIES_COLUMN_PROJECT_ID + " int NOT NULL, " +
			PROJECT_CATEGORIES_COLUMN_CAT_ID + " int NOT NULL, " +
			"FOREIGN KEY (" + PROJECT_CATEGORIES_COLUMN_PROJECT_ID + ") REFERENCES " +
			TABLE_PROJECTS + "(" + PROJECTS_COLUMN_ID + "), " +
			"FOREIGN KEY (" + PROJECT_CATEGORIES_COLUMN_CAT_ID + ") REFERENCES " +
			TABLE_CATEGORIES + "(" + CATEGORIES_COLUMN_ID + ")" +
			");";
	
	public static final String CREATE_TABLE_USER_TASKS =
			"CREATE TABLE " + TABLE_USER_TASKS + "(" +
			USER_TASKS_COLUMN_USER_ID + " int NOT NULL, " +
			USER_TASKS_COLUMN_TASK_ID + " int NOT NULL, " +
			"FOREIGN KEY (" + USER_TASKS_COLUMN_USER_ID + ") REFERENCES " +
			TABLE_USERS + "(" + USERS_COLUMN_ID + "), " +
			"FOREIGN KEY (" + USER_TASKS_COLUMN_TASK_ID + ") REFERENCES " +
			TABLE_TASKS + "(" + TASKS_COLUMN_ID + ")" +
			");";
	
	// TABLE CREATION QUERIES x2 WITH SINGLE FOREIGN KEY
	
	public static final String CREATE_TABLE_TASKS =
			"CREATE TABLE " + TABLE_TASKS + "(" +
			TASKS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			TASKS_COLUMN_TITLE + " VARCHAR(20), " +
			TASKS_COLUMN_DESCRIPTION + " VARCHAR(75), " +
			TASKS_COLUMN_HOURS + " DECIMAL(4,2), " +
			TASKS_COLUMN_DATE + " DATE, " +
			TASKS_COLUMN_PROJECT_ID + " int NOT NULL, " +
			"FOREIGN KEY (" + TASKS_COLUMN_PROJECT_ID + ") REFERENCES " +
			TABLE_PROJECTS + "(" + PROJECTS_COLUMN_ID + "), " +
			"PRIMARY KEY(" + TASKS_COLUMN_ID + ")" +
			");";
}
