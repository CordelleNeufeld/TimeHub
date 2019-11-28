package classes;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import static database.Const.*;

public class Database {

    private static Database instance = null;
    private Connection connection = null;

    private Database() {
        try {
            Scanner configReader = new Scanner(new File("config.txt"));

            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + configReader.nextLine() + "/" + configReader.nextLine(),
                        configReader.nextLine(), configReader.nextLine());

                String[] createTables = {CREATE_TABLE_CATEGORIES, CREATE_TABLE_PROJECTS, CREATE_TABLE_PROJECT_CATEGORIES, CREATE_TABLE_TASKS, CREATE_TABLE_USERS, CREATE_TABLE_USER_TASKS};

                for (String createTable : createTables) {
                    try {
                        connection.createStatement().execute(createTable);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Created Connection");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException x) {
            x.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection() == null) {
            instance = new Database();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}