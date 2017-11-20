package pizzacalories;

public enum ToppingType {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    private double calories;

    ToppingType(double calories) {
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
