package shopping_spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        this.money -= product.getCost();
        this.bagOfProducts.add(product);
    }

    public boolean hasEnoughMoney(double productCost) {
        return this.money >= productCost;
    }

    private void setName(String name) {
        if (name == null || name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.bagOfProducts.size() == 0 ? "Nothing bought" : this.bagOfProducts.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}
