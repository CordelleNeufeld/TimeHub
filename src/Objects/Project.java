package Objects;

public class Project {
    private Category[] categories;
    private String title;
    private String description;

    /**
     *
     * @param categories Project Category
     * @param title Project Title
     * @param description Project Description
     */
    public Project(Category[] categories, String title, String description) {
        this.categories = categories;
        this.title = title;
        this.description = description;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
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
