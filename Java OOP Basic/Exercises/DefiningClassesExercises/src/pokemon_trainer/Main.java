package pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String line;

        while (true) {
            if ("Tournament".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            Pokemon pokemon = new Pokemon(tokens[1], tokens[2], Integer.parseInt(tokens[3]));

            Trainer trainer = new Trainer(tokens[0]);

            if (!trainers.containsKey(trainer.getName())) {
                trainers.put(trainer.getName(), trainer);
            }
            trainers.get(trainer.getName()).addPokemon(pokemon);
        }

        String element;
        while (true) {
            if ("End".equalsIgnoreCase(element = reader.readLine())) {
                break;
            }

            checkTrainers(trainers, element);
        }

        trainers.values()
                .stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }

    private static void checkTrainers(Map<String, Trainer> trainers, String element) {
        for (Trainer trainer : trainers.values()) {
            if(trainer.hasElement(element)) {
                trainer.addBadge();
            } else {
                trainer.allPokemonsReduceHealth();
            }
        }
    }
}
