package javabeans;

import java.util.ArrayList;

public class Project {
    private int id;
    private ArrayList<Category> categories;
    private ArrayList<Task> tasks;
    private String title;
    private String description;

    /**
     * @param id          Project Id
     * @param categories  Project Categories
     * @param tasks       Project Tasks
     * @param title       Project Title
     * @param description Project Description
     */
    public Project(int id, ArrayList<Category> categories, ArrayList<Task> tasks, String title, String description) {
        this.id = id;
        this.categories = categories;
        this.tasks = tasks;
        this.title = title;
        this.description = description;
    }

    /**
     * Secondary constructor for creating new Projects
     *
     * @param categories  Project Categories
     * @param tasks       Project Tasks
     * @param title       Project Title
     * @param description Project Description
     */
    public Project(ArrayList<Category> categories, ArrayList<Task> tasks, String title, String description) {
        this.id = 0;
        this.categories = categories;
        this.tasks = tasks;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
    	return this.title;
    }
}