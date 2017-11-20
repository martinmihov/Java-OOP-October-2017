package animals;

public class Cat extends Animal {
    private static final String SOUND = "MiauMiau";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return SOUND;
    }
}
