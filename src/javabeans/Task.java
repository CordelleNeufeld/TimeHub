package javabeans;

import java.sql.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date date;
    private double hours;

    /**
     * @param id          Task Id
     * @param title       Task Title
     * @param description Task Description
     * @param date        Task Date
     * @param hours       Task hours
     */
    public Task(int id, String title, String description, Date date, double hours) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.hours = hours;
    }

    /**
     * Secondary constructor for creating new Tasks
     *
     * @param title       Task Title
     * @param description Task Description
     * @param date        Task Date
     * @param hours       Task hours
     */
    public Task(String title, String description, Date date, double hours) {
        this.id = 0;
        this.title = title;
        this.description = description;
        this.date = date;
        this.hours = hours;
    }

    public int getId() {
        return id;
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

    public Date getDate() {
        return date;
    }

    public Double getHours() {
        return hours;
    }
}