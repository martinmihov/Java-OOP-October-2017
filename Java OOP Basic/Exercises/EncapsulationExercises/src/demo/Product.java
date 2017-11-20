package demo;

class Product {
    private String name;
    private double price;

    public Product(String name, double cost){
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (!name.isEmpty() || name.trim().length() == 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public double getCost() {
        return price;
    }

    private void setCost(double cost) {
        if (cost >= 0) {
            this.price = cost;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }
}
