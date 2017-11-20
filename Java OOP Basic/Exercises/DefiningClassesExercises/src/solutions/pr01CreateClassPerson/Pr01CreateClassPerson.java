package solutions.pr01CreateClassPerson;

import java.lang.reflect.Field;

class Person {
    String name;
    int age;
}

public class Pr01CreateClassPerson {

    public static void main(String[] args) throws Exception {
        Class person = Class.forName("Person");
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
