package food_shortage;

public class Citizen extends BaseResident implements Birthday, Buyer {

    private String name;
    private int age;
    private String birthDay;
    private int food;

    public Citizen(String name, int age, String id, String birthDay) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.food = 0;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
