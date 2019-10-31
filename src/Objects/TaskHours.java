package Objects;

import java.sql.Date;

public class TaskHours {
    private Task task;
    private Date date;
    private Double hours;

    /**
     *
     * @param task The Task the hours are connected to
     * @param date Date the user worked on the task
     * @param hours Hours added to the task
     */
    public TaskHours(Task task, Date date, Double hours) {
        this.task = task;
        this.date = date;
        this.hours = hours;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }
}
