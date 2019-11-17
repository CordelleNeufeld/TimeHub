package javabeans;

public class Category {
    private int id;
    private String title;
    private String description;

    /**
     * @param id          Category Id
     * @param title       Category Name
     * @param description Category description
     */
    public Category(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    /**
     * Secondary Constructor for creating new Categories
     *
     * @param title       Category Name
     * @param description Category description
     */
    public Category(String title, String description) {
        this.id = 0;
        this.title = title;
        this.description = description;
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
}