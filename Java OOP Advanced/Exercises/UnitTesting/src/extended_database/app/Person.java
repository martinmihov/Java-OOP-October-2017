package extended_database.app;

public class Person {

    private String username;
    private int id;

    public Person(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }
}
