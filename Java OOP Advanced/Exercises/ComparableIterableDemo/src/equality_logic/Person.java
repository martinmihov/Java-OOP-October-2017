package equality_logic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.compareTo(person.name) != 0) {
            return this.name.compareTo(person.name);
        }
        return Integer.compare(this.age, person.age);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        return person.name.equals(this.name) &&
                person.age == this.age;
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.age;
        return result;
    }
}
