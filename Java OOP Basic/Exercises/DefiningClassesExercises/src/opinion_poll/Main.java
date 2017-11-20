package opinion_poll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        int countOfPersons = Integer.parseInt(bufferedReader.readLine());

        while (countOfPersons-- > 0) {
            String[] personTokens = bufferedReader.readLine().split("\\s+");
            int age = Integer.parseInt(personTokens[1]);
            if (age > 30) {
                Person person = new Person(personTokens[0], age);
                people.add(person);
            }
        }

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}