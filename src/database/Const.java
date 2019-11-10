package database;

public class Const {
	
	// TASKS TABLE
	public static final String TABLE_TASKS = "tasks";
	public static final String TASKS_COLUMN_ID = "id";
	public static final String TASKS_COLUMN_PROJECT_ID = "project_id";
	public static final String TASKS_COLUMN_TITLE = "title";
	public static final String TASKS_COLUMN_DESCRIPTION = "description";
	
	// TASK HOURS TABLE
	public static final String TABLE_TASK_HOURS = "task_hours";
	public static final String TASK_HOURS_COLUMN_TASK_ID = "task_id";
	public static final String TASK_HOURS_COLUMN_HOURS = "hours";
	public static final String TASK_HOURS_COLUMN_DATE = "date";
	
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
	public static final String TABLE_CATEGORIES = "projects";
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

}
