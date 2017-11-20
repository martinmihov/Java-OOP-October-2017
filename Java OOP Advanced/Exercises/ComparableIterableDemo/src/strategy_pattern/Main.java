package strategy_pattern;

import strategy_pattern.comparators.PersonAgeComparator;
import strategy_pattern.comparators.PersonNameComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> peopleSortByName = new TreeSet<>(new PersonNameComparator());
        Set<Person> peopleSortByAge = new TreeSet<>(new PersonAgeComparator());

        int countOfPeople = Integer.parseInt(reader.readLine());

        while (countOfPeople-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleSortByName.add(person);
            peopleSortByAge.add(person);
        }

        peopleSortByName.forEach(System.out::println);
        peopleSortByAge.forEach(System.out::println);
    }
}
