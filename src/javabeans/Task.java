package javabeans;

import java.sql.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date date;
    private double hours;
    private int projectId;

    /**
     * @param id          Task Id
     * @param title       Task Title
     * @param description Task Description
     * @param date        Task Date
     * @param hours       Task hours
     */
    public Task(int id, String title, String description, Date date, double hours, int projectId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.hours = hours;
        this.projectId = projectId;
    }

    /**
     * Secondary constructor for creating new Tasks
     *
     * @param title       Task Title
     * @param description Task Description
     * @param date        Task Date
     * @param hours       Task hours
     */
    public Task(String title, String description, Date date, double hours, int projectId) {
        this.id = 0;
        this.title = title;
        this.description = description;
        this.date = date;
        this.hours = hours;
        this.projectId = projectId;
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}