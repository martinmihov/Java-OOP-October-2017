package pet_clinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfLines = Integer.parseInt(reader.readLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        while (countOfLines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("Create".equalsIgnoreCase(tokens[0])) {
                switch (tokens[1]) {
                    case "Clinic":
                        try {
                            Clinic clinic = new Clinic(tokens[2], Integer.parseInt(tokens[3]));
                            clinics.putIfAbsent(tokens[2], clinic);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    case "Pet":
                        Pet pet = new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
                        pets.putIfAbsent(tokens[2], pet);
                        break;
                }
            }
            switch (tokens[0]) {
                case "Add":
                    if (pets.containsKey(tokens[1]) && clinics.containsKey(tokens[2])) {
                        System.out.println(clinics.get(tokens[2]).addPet(pets.get(tokens[1])));
                    }
                    break;
                case "Print":
                    if (tokens.length == 3 && clinics.containsKey(tokens[1])) {
                        Room room = clinics.get(tokens[1]).getRoomByIndex(Integer.parseInt(tokens[2]));
                        System.out.println(room == null ? "Room empty" : room.getPet());
                    } else if (clinics.containsKey(tokens[1])) {
                        clinics.get(tokens[1]).forEach(r -> {
                            if (r == null) {
                                System.out.println("Room empty");
                            } else {
                                System.out.println(r);
                            }
                        });
                    }
                    break;
                case "HasEmptyRooms":
                    if (clinics.containsKey(tokens[1])) {
                        System.out.println(clinics.get(tokens[1]).hasEmptyRoom());
                    }
                    break;
                case "Release":
                    if (clinics.containsKey(tokens[1])) {
                        System.out.println(clinics.get(tokens[1]).release());
                    }
            }
        }
    }
}
