package PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

       Map<String,Pet> allPets = new HashMap<>();
       Map<String,ClinicImpl> clinics = new HashMap<>();


        int number = Integer.parseInt(console.readLine());
        for (int i = 0; i < number; i++) {
            String[] commands = console.readLine().split("\\s+");
            try {
                switch (commands[0]) {
                    case "Create":
                        if (commands[1].equalsIgnoreCase("Pet")) {
                            Pet pet = new PetImpl(commands[2], Integer.parseInt(commands[3]), commands[4]);
                            allPets.put(commands[2],pet);
                        } else if (commands[1].equalsIgnoreCase("Clinic")) {
                            ClinicImpl clinic = new ClinicImpl(commands[2], Integer.parseInt(commands[3]));
                            clinics.put(commands[2],clinic);
                        }
                        break;
                    case "Add":
                        System.out.println(clinics.get(commands[2]).addPet(allPets.get(commands[1])));
                        break;
                    case "Release":
                        System.out.println(clinics.get(commands[1]).release());
                        break;
                    case "HasEmptyRooms":
                        System.out.println(clinics.get(commands[1]).hasEmptyRooms());
                        break;
                    case "Print":
                        if (commands.length == 2){
                            clinics.get(commands[1]).print();
                        }
                        else if (commands.length == 3){
                           clinics.get(commands[1]).printRoom(Integer.parseInt(commands[2]));
                        }
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
