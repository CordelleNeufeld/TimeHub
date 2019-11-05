package Objects.DatabaseObjects;

import java.util.ArrayList;

public class Project {
    private ArrayList<Category> categories;
    private ArrayList<Task> tasks;
    private String title;
    private String description;

    /**
     *
     * @param categories Project Categories
     * @param tasks Project Tasks
     * @param title Project Title
     * @param description Project Description
     */
    public Project(ArrayList<Category> categories, ArrayList<Task> tasks, String title, String description) {
        this.categories = categories;
        this.tasks = tasks;
        this.title = title;
        this.description = description;
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
}
