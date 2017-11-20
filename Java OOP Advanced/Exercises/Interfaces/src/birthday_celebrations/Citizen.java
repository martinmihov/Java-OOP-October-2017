package birthday_celebrations;

public class Citizen extends Resident implements Birthdayable {

    private String name;
    private int age;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthday() {
        return this.birthDate;
    }
}
