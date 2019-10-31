package Objects;

public class Task {
    private Project project;
    private String title;
    private String description;

    /**
     *
     * @param project Project the Task is under
     * @param title Task Title
     * @param description Task Description
     */
    public Task(Project project, String title, String description) {
        this.project = project;
        this.title = title;
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
