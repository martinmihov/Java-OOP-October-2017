package pizzacalories;

public enum BakingTechnique {
    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1.0);

    private double calories;

    BakingTechnique(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
