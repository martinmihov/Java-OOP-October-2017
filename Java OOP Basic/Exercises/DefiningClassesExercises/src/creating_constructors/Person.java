package creating_constructors;

public class Person {
    private static final String DEFAULT_NAME = "No name";
    private static final int DEFAULT_AGE = 1;

    public String name;
    public int age;

    public Person() {
        this.name = DEFAULT_NAME;
        this.age = DEFAULT_AGE;
    }

    public Person(int age) {
        this();
        this.age = age;
    }

    public Person(String name, int age) {
        this(age);
        this.name = name;
    }
}
