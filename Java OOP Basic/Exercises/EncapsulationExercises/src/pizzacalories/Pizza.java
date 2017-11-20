package pizzacalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppingList;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name.isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppingList(int numberOfToppings) {
        if(numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("The number of toppings should be in range [0...10]");
        }
        this.toppingList = new ArrayList<>(numberOfToppings);
    }

    public void addTopping(Topping topping) {
        this.toppingList.add(topping);
    }

    public double getPizzaCalories() {

        double doughCalories = this.dough.getCalories();
        double toppingsCalories = 0;
        for (Topping topping : this.toppingList) {
            toppingsCalories += topping.getCalories();
        }

        return doughCalories + toppingsCalories;
    }
}
