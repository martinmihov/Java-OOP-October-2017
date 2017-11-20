package family_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String startingKey = reader.readLine();

        List<String> parentChildrenCouples = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        String line;

        while (true) {
            if ("end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            if (line.contains("-")) {
                parentChildrenCouples.add(line);
                continue;
            }

            String[] tokens = line.split("\\s+");

            Person person = new Person(tokens[0], tokens[1], tokens[2]);
            people.add(person);
        }

        Person myPerson = people.stream().filter(p -> p.getFullName().equals(startingKey) || p.getDate().equals(startingKey)).findFirst().orElse(null);

        List<String> parents = new ArrayList<>();
        List<String> children = new ArrayList<>();

        for (String couple : parentChildrenCouples) {
            String[] coupleTokens = couple.split(" - ");

            String father = coupleTokens[0];
            String child = coupleTokens[1];

            if (father.equals(myPerson.getDate()) || father.equals(myPerson.getFullName())) {
                 children.add(child);
            } else if (child.equals(myPerson.getDate()) || child.equals(myPerson.getFullName())) {
                parents.add(father);
            }
        }

        StringBuilder sb = new StringBuilder(myPerson.toString()).append(System.lineSeparator());
        sb.append("Parents:").append(System.lineSeparator());
        for (String parent : parents) {
            sb.append(people.stream().filter(p -> p.getFullName().equals(parent) || p.getDate().equals(parent)).findFirst().orElse(null)).append(System.lineSeparator());
        }

        sb.append("Children:").append(System.lineSeparator());
        for (String child : children) {
            sb.append(people.stream().filter(p -> p.getFullName().equals(child) || p.getDate().equals(child)).findFirst().orElse(null)).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}