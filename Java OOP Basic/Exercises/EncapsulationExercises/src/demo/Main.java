package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static LinkedHashMap<String, Person> people = new LinkedHashMap<>();
    static LinkedHashMap<String, Product> products = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        readThePeople();
        readThePrices();
        receiveCommands();
        printResults();
    }

    private static void printResults() {
            for (Map.Entry<String, Person> person : people.entrySet()) {
                if (person.getValue().getProductListSize() > 0) {
                    System.out.printf(person.getKey() + " - " + person.getValue().getProducts());

                } else {
                    System.out.printf("%s - Nothing bought%n", person.getKey());
                }
            }
    }

    private static void receiveCommands() throws IOException {
        String[] tokens = bf.readLine().split("\\s+");
        while (!"END".equals(tokens[0])) {
                String personName = tokens[0];
                String productName = tokens[1];
                try {
                    if (people.containsKey(personName) && products.containsKey(productName)) {
                        people.get(personName).addProduct(products.get(productName));
                        System.out.printf("%s bought %s%n",personName ,productName);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            tokens = bf.readLine().split("\\s+");
            }
    }

    private static void readThePrices() throws IOException {
            String[] tokens = bf.readLine().split(";");
            for (String token : tokens) {
                String[] productData = token.split("=");
                String productName = productData[0].trim();
                double productCost = Double.parseDouble(productData[1]);
                try {
                    Product newProduct = new Product(productName, productCost);
                    products.put(productName, newProduct);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    private static void readThePeople() throws IOException {
            String[] tokens = bf.readLine().trim().split(";");
            for (String token : tokens) {
                String[] personData = token.split("=");
                String name = personData[0].trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty");
                    return;
                }
                double money = Double.parseDouble(personData[1].trim());
                if (money < 0) {
                    System.out.println("Money cannot be negative");
                    return;
                }
                Person newPerson = new Person(name, money);
                people.put(name, newPerson);
            }
    }
}
