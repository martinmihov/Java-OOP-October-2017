package animals;

public class Frog extends Animal {
    private static final String SOUND = "Frogggg";

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return SOUND;
    }
}
