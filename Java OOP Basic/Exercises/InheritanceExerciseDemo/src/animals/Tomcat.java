package animals;

public class Tomcat extends Cat {
    private static final String SOUND = "Give me one million b***h";

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.equals(MALE_GENDER)) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        super.setGender(gender);
    }

    public String produceSound() {
        return SOUND;
    }
}
