package animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR_MESSAGE);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR_MESSAGE);
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR_MESSAGE);
        }
        this.gender = gender;
    }

    public String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append(String.format("%s %d %s", this.name, this.age, this.gender)).append(System.lineSeparator())
                .append(this.produceSound());
        return sb.toString();
    }
}