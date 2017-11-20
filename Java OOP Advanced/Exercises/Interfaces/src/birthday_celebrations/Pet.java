package birthday_celebrations;

public class Pet implements Birthdayable {

    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthday() {
        return this.birthDate;
    }
}
