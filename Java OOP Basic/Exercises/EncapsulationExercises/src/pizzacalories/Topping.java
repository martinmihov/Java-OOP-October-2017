package pizzacalories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hristo on 24.02.2017 г..
 */
public class Topping {

    private static final int BASE_CALORIES_PER_GRAM = 2;

    private ToppingType toppingType;
    private int weight;

    public Topping(String toppingType, int weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        List<String> types = new ArrayList<>();
        Collections.addAll(types, "meat", "veggies", "cheese", "sauce");
        if (!types.contains(toppingType.toLowerCase())) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = ToppingType.valueOf(toppingType.toUpperCase());
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double getCalories() {
        double totalCalories = BASE_CALORIES_PER_GRAM *
                this.toppingType.getCalories() *
                this.weight;
        return totalCalories;
    }

}
