package Objects;

public class Project {
    private Category category;
    private String title;
    private String description;

    /**
     *
     * @param category Project Category
     * @param title Project Title
     * @param description Project Description
     */
    public Project(Category category, String title, String description) {
        this.category = category;
        this.title = title;
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
