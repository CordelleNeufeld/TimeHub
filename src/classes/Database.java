package classes;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import database.Const;

public class Database {

    private static Database instance = null;
    private Connection connection = null;

    private Database() {
        if (connection == null) {
            try {
                Scanner configReader = new Scanner(new File("config.txt"));

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://" + configReader.nextLine() + "/" + configReader.nextLine(),
                            configReader.nextLine(), configReader.nextLine());
                    
                    connection.createStatement().execute(Const.CREATE_TABLE_CATEGORIES);
                    connection.createStatement().execute(Const.CREATE_TABLE_PROJECTS);
                    connection.createStatement().execute(Const.CREATE_TABLE_PROJECT_CATEGORIES);
                    connection.createStatement().execute(Const.CREATE_TABLE_TASKS);
                    connection.createStatement().execute(Const.CREATE_TABLE_TASK_HOURS);
                    connection.createStatement().execute(Const.CREATE_TABLE_USERS);
                    connection.createStatement().execute(Const.CREATE_TABLE_USER_TASKS);
                    
                    System.out.println("Created Connection");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException x) {
                x.printStackTrace();
            }
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
	public Connection getConnection() {
		return connection;
	}
	
}