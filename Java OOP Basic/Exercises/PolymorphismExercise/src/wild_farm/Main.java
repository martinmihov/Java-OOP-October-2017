package wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String pattern = "#.##";
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(pattern);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        List<Animal> animals = new ArrayList<>();

        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] animalTokens = line.split("\\s+");
            Animal animal = createAnimal(animalTokens);

            String[] foodTokens = reader.readLine().split("\\s+");
            Food food = createFood(foodTokens);

            if (animal != null) {
                System.out.println(animal.makeSound());
                if (food != null) {
                    try {
                        animal.eat(food, food.getQuantity());
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                }
                animals.add(animal);
            }
        }
        animals.forEach(System.out::println);
    }

    private static Animal createAnimal(String[] tokens) {
        switch (tokens[0]) {
            case "Cat":
                return new Cat(tokens[1], tokens[0], Double.parseDouble(tokens[2]), 0, tokens[3], tokens[4]);
            case "Tiger":
                return new Tiger(tokens[1], tokens[0], Double.parseDouble(tokens[2]), 0, tokens[3]);
            case "Mouse":
                return new Mouse(tokens[1], tokens[0], Double.parseDouble(tokens[2]), 0, tokens[3]);
            case "Zebra":
                return new Zebra(tokens[1], tokens[0], Double.parseDouble(tokens[2]), 0, tokens[3]);
            default:
                return null;
        }
    }

    private static Food createFood(String[] tokens) {
        switch (tokens[0]) {
            case "Vegetable":
                return new Vegetable(Integer.parseInt(tokens[1]));
            case "Meat":
                return new Meat(Integer.parseInt(tokens[1]));
            default:
                return null;
        }
    }
}
