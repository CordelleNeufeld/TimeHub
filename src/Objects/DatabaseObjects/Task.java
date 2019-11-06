package Objects.DatabaseObjects;

import java.util.ArrayList;

public class Task {
    private Project project;
    private ArrayList<TaskHours> taskHours;
    private String title;
    private String description;

    /**
     *
     * @param project Project the Task is under
     * @param taskHours Task TaskHours
     * @param title Task Title
     * @param description Task Description
     */
    public Task(Project project, ArrayList<TaskHours> taskHours, String title, String description) {
        this.project = project;
        this.taskHours = taskHours;
        this.title = title;
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ArrayList<TaskHours> getTaskHours() {
        return taskHours;
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