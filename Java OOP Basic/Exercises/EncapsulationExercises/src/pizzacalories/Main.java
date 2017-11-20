package pizzacalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Hristo on 24.02.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Pizza pizza = new Pizza();

        try {
            String line;
            while (true) {
                if ("end".equalsIgnoreCase(line = bufferedReader.readLine())) {
                    break;
                }

                String[] tokens = line.split("\\s+");

                switch (tokens[0]) {
                    case "Pizza":
                        break;
                    case "Dough":
                        Dough dough = new Dough(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                        System.out.println(String.format("%.2f", dough.getCalories()));
                        break;
                    case "Topping":
                        break;
                }
            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    public static Pizza executePizza(String line, Pizza pizza) {
        String[] lineArgs = line.split("\\s+");

        switch (lineArgs[0]) {
            case "Pizza":
                String pizzaName = lineArgs[1];
                int numberOfToppings = Integer.parseInt(lineArgs[2]);

                pizza.setName(pizzaName);
                pizza.setToppingList(numberOfToppings);
                break;
            case "Dough":
                String flourType = lineArgs[1];
                String bakingTechnique = lineArgs[2];
                int weight = Integer.parseInt(lineArgs[3]);

                Dough dough = new Dough(flourType, bakingTechnique, weight);

                pizza.setDough(dough);
                break;
            case "Topping":
                String toppingType = lineArgs[1];
                weight = Integer.parseInt(lineArgs[2]);

                Topping topping = new Topping(toppingType, weight);

                pizza.addTopping(topping);
                break;
        }
        return pizza;
    }

    public static void executeClassesWithoutPizza(String line) {
        String[] lineArgs = line.split("\\s+");

        switch (lineArgs[0]) {
            case "Dough":
                String flourType = lineArgs[1];
                String bakingTechnique = lineArgs[2];
                int weight = Integer.parseInt(lineArgs[3]);

                Dough dough = new Dough(flourType, bakingTechnique, weight);

                System.out.println(String.format("%.2f", dough.getCalories()));
                break;
            case "Topping":

                String toppingType = lineArgs[1];
                weight = Integer.parseInt(lineArgs[2]);

                Topping topping = new Topping(toppingType, weight);

                System.out.println(String.format("%.2f", topping.getCalories()));
                break;
        }

    }
}
