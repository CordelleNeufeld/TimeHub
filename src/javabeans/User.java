package javabeans;

import java.util.ArrayList;

public class User {
	private int id;
    private String firstName;
    private String lastName;
    private String lastAccessed;
    private ArrayList<Task> tasks;

    /**
     * @param firstName First Name of user
     * @param lastName Last Name of the user
     * @param lastAccessed Last time the user Accessed the Program
     * @param tasks Tasks the user is assigned
     */
    public User(int id, String firstName, String lastName, String lastAccessed, ArrayList<Task> tasks) {
    	this.id = id;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.lastAccessed = lastAccessed;
        this.tasks = tasks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastAccessed() {
        return lastAccessed;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
    
    public int getId() {
		return id;
	}
    
}