package animal_farm;

public class Chicken {
    private String name;
    private int age;
    private String productPerDay;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }


    public int getAge() {
        return this.age;
    }

    public String getProductPerDay() {
        return calculateProductPerDay();
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void setName(String name) {
        if (name == null || name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private String calculateProductPerDay() {
        if (this.age < 6) {
            return "2";
        } else if (this.age <= 12) {
            return "1";
        } else {
            return "0.75";
        }
    }
}
