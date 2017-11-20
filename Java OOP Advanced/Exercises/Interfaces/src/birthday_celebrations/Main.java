package birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> residentsWithId = new ArrayList<>();
        List<Birthdayable> residentsWithBirthdates = new ArrayList<>();

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            Identifiable residentWithId = null;
            Birthdayable residentWithBirthDay = null;
            if (tokens[0].equals("Robot")) {
                residentWithId = new Robot(tokens[2], tokens[1]);
            } else if (tokens[0].equals("Citizen")) {
                residentWithId = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                residentWithBirthDay = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
            } else {
                residentWithBirthDay = new Pet(tokens[1], tokens[2]);
            }

            if (residentWithId != null) {
                residentsWithId.add(residentWithId);
            }
            if (residentWithBirthDay != null) {
                residentsWithBirthdates.add(residentWithBirthDay);
            }
        }

        String birthYear = reader.readLine();

        residentsWithBirthdates.stream()
                .filter(r -> r.getBirthday().endsWith(birthYear))
                .map(Birthdayable::getBirthday)
                .forEach(System.out::println);
    }
}
