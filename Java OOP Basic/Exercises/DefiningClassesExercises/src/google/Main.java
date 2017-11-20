package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();

        String line;
        while (true) {
            if ("end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String personName = tokens[0];

            if (!people.containsKey(personName)) {
                people.putIfAbsent(personName, new Person(personName));
            }

            switch (tokens[1]) {
                case "company":
                    people.get(personName).addCompanyInfo(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    break;
                case "pokemon":
                    people.get(personName).addPokemon(tokens[2], tokens[3]);
                    break;
                case "parents":
                    people.get(personName).addParent(tokens[2], tokens[3]);
                    break;
                case "children":
                    people.get(personName).addChild(tokens[2], tokens[3]);
                    break;
                case "car":
                    people.get(personName).addCar(tokens[2], Integer.parseInt(tokens[3]));
                    break;
            }
        }

        System.out.println(people.get(reader.readLine()));
    }
}
