package pizzacalories;

public enum FlourType {
    WHITE(1.5),
    WHOLEGRAIN(1.0);

    private double calories;

    FlourType(double calories) {
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
