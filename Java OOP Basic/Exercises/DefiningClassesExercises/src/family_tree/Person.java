package family_tree;

public class Person {
    private String firstName;
    private String lastName;
    private String date;

    public Person(String firstName, String lastName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getFullName(), this.date);
    }
}