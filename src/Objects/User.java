package Objects;

public class User {
    private String firstName;
    private String lastName;
    private String lastAccessed;

    /**
     * @param firstName First Name of user
     * @param lastName Last Name of the user
     * @param lastAccessed Last time the user Accessed the Program
     */
    public User(String firstName, String lastName, String lastAccessed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastAccessed = lastAccessed;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastAccessed() {
        return lastAccessed;
    }
}
