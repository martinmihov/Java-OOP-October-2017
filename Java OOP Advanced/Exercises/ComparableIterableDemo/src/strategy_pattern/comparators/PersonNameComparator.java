package strategy_pattern.comparators;

import strategy_pattern.Person;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int comparatorByNameLength = person1.getName().length() - person2.getName().length();
        if (comparatorByNameLength != 0) {
            return comparatorByNameLength;
        }
        return person1.getName().toLowerCase().charAt(0) - person2.getName().toLowerCase().charAt(0);
    }
}
