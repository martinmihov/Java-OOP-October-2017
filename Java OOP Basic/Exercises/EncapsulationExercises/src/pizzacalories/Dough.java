package pizzacalories;

/**
 * Created by Hristo on 24.02.2017 г..
 */
public class Dough {

    private static final int BASE_CALORIES_PER_GRAM = 2;

    private FlourType flourType;
    private BakingTechnique bakingTechnique;
    private int weight;

    public Dough(String flourType, String bakingTechnique, int weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public double getCalories() {
        double totalCalories = this.flourType.getCalories() *
                this.bakingTechnique.getCalories() *
                this.weight *
                BASE_CALORIES_PER_GRAM;
        return totalCalories;
    }

    private void setFlourType(String flourType) {
        try {
            this.flourType = FlourType.valueOf(flourType.toUpperCase());
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            this.bakingTechnique = BakingTechnique.valueOf(bakingTechnique.toUpperCase());
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

}