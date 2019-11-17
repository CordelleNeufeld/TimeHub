package javabeans;

import java.util.ArrayList;

public class Task {
    private int id;
    private ArrayList<TaskHour> taskHours;
    private String title;
    private String description;

    /**
     * @param id          Task Id
     * @param taskHours   Task TaskHours
     * @param title       Task Title
     * @param description Task Description
     */
    public Task(int id, ArrayList<TaskHour> taskHours, String title, String description) {
        this.id = id;
        this.taskHours = taskHours;
        this.title = title;
        this.description = description;
    }

    /**
     * Secondary constructor for creating new Tasks
     *
     * @param taskHours   Task TaskHours
     * @param title       Task Title
     * @param description Task Description
     */
    public Task(ArrayList<TaskHour> taskHours, String title, String description) {
        this.id = 0;
        this.taskHours = taskHours;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }



    public ArrayList<TaskHour> getTaskHours() {
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