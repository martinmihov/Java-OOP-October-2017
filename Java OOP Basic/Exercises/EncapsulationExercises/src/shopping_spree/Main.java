package shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] peopleTokens = reader.readLine().split("[;=]");
        String[] productsTokens = reader.readLine().split("[;=]");

        try {

            for (int i = 0; i < peopleTokens.length; i += 2) {
                Person person = new Person(peopleTokens[i], Double.parseDouble(peopleTokens[i + 1]));
                people.putIfAbsent(person.getName(), person);
            }

            for (int i = 0; i < productsTokens.length; i += 2) {
                Product product = new Product(productsTokens[i], Double.parseDouble(productsTokens[i + 1]));
                products.putIfAbsent(product.getName(), product);
            }

            String line;
            while (true) {
                if ("end".equalsIgnoreCase(line = reader.readLine())) {
                    break;
                }

                String[] purchase = line.split(" ");

                if (people.containsKey(purchase[0]) && products.containsKey(purchase[1])) {
                    Person person = people.get(purchase[0]);
                    Product product = products.get(purchase[1]);

                    if (person.hasEnoughMoney(product.getCost())) {
                        person.buyProduct(product);
                        System.out.println(String.format("%s bought %s", person.getName(), product.getName()));
                    } else {
                        System.out.println(String.format("%s can't afford %s", person.getName(), product.getName()));
                    }
                }
            }
            people.values().forEach(System.out::println);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}