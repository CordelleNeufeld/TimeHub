package Objects;

import java.sql.Date;

public class TaskHours {
    private Date date;
    private Double hours;

    /**
     *
     * @param date Date the user worked on the task
     * @param hours Hours added to the task
     */
    public TaskHours(Date date, Double hours) {
        this.date = date;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public Double getHours() {
        return hours;
    }
}
