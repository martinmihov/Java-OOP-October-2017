package border_control;

public class Citizen extends Resident {

    private String name;
    private int age;

    public Citizen(String name, int age, String id) {
        super(id);
        this.name = name;
        this.age = age;
    }


}
