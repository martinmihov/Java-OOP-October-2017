package comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        String line;
        while (true) {
            if ("END".equalsIgnoreCase(line= reader.readLine())) {
                break;
            }

            String[] personTokens = line.split("\\s+");
            Person person = new Person(personTokens[0], Integer.parseInt(personTokens[1]), personTokens[2]);
            people.add(person);
        }

        int personIndex = Integer.parseInt(reader.readLine());
        int countOfEqual = 0;
        if (personIndex >= 0 && personIndex < people.size()) {
            Person mainPerson = people.get(personIndex);
            for (Person person : people) {
                if (mainPerson.compareTo(person) == 0) {
                    countOfEqual++;
                }
            }
        }

        System.out.println(countOfEqual == 0 ? "No matches" : String.format("%d %d %d", countOfEqual, people.size() - countOfEqual, people.size()));

    }
}
