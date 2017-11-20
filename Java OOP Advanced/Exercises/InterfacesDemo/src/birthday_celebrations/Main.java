package birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthday> residentsWithBirthDay = new ArrayList<>();
        List<Identifiable> residentsWithId = new ArrayList<>();

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            Identifiable resident = null;
            Birthday residentWithBirthDay = null;
            if (tokens[0].equalsIgnoreCase("Citizen")) {
                resident = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                residentWithBirthDay = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
            } else if (tokens[0].equalsIgnoreCase("Robot")) {
                resident = new Robot(tokens[0], tokens[1]);
            } else {
                residentWithBirthDay = new Pet(tokens[1], tokens[2]);
            }

            if (residentWithBirthDay != null) {
                residentsWithBirthDay.add(residentWithBirthDay);
            }
            residentsWithId.add(resident);
        }

        String year = reader.readLine();

        residentsWithBirthDay.stream()
                .filter(r -> r.getBirthDay().endsWith(year))
                .forEach(r -> System.out.println(r.getBirthDay()));

    }
}
