package birthday_celebrations;

public class Citizen extends BaseResident implements Birthday {

    private String name;
    private int age;
    private String birthDay;

    public Citizen(String name, int age, String id, String birthDay) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }
}
