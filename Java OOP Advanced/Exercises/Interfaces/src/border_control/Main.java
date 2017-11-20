package border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> residents = new ArrayList<>();

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            Identifiable resident = null;
            if (tokens.length == 2) {
                resident = new Robot(tokens[1], tokens[0]);
            } else {
                resident = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            residents.add(resident);
        }

        String lastDigitsOfId = reader.readLine();

        residents.stream()
                .filter(r -> r.getId().endsWith(lastDigitsOfId))
                .map(Identifiable::getId)
                .forEach(System.out::println);
    }
}
