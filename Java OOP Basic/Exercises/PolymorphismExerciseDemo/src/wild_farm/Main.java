package wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PATTERN = "#.##";
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(PATTERN);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] animalTokens = line.split("\\s+");
            Animal animal = createAnimal(animalTokens);

            String[] foodTokens = reader.readLine().split("\\s+");
            Food food = createFood(foodTokens);

            System.out.println(animal.makeSound());
            try {
                animal.eat(food, food.getQuantity());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            animals.add(animal);
        }
        animals.forEach(System.out::println);
    }

    private static Food createFood(String[] foodTokens) {
        switch (foodTokens[0]) {
            case "Vegetable":
                return new Vegetable(Integer.parseInt(foodTokens[1]));
            case "Meat":
                return new Meat(Integer.parseInt(foodTokens[1]));
            default:
                return null;
        }
    }

    private static Animal createAnimal(String[] tokens) {
        switch (tokens[0]) {
            case "Cat":
                return new Cat(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
            case "Tiger":
                return new Tiger(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);
            case "Zebra":
                return new Zebra(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);
            case "Mouse":
                return new Mouse(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);
            default:
                return null;
        }
    }
}
