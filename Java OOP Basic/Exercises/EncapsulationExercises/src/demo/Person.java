package demo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private double money;
    private LinkedList<Product> products = new LinkedList<>();

    public Person(String name, double money) {
        try {
            setName(name);
            setMoney(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getProductListSize() {
        return this.products.size();
    }

    public String getProducts() {
        List<Product> unmodifiableList = Collections.unmodifiableList(this.products);
        return String.join(", ", unmodifiableList.stream().map(Product::getName).collect(Collectors.toList())) + "\n";
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setMoney(double money) {
        this.money = money;
    }

    public void addProduct(Product product) {

           double balance = this.money - product.getCost();
           if (balance >= 0) {
               this.products.add(product);
               this.money -= product.getCost();
           } else {
               throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
           }
    }

}
