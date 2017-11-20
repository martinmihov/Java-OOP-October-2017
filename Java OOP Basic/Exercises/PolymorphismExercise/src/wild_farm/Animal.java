package wild_farm;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalName, String animalType, double animalWeight, int foodEaten) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = foodEaten;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected double getAnimalWeight() {
        return this.animalWeight;
    }

    protected int getFoodEaten() {
        return this.foodEaten;
    }

    protected abstract String makeSound();

    public void eat(Food food, int foodsQuantity) {
        this.foodEaten += foodsQuantity;
    }
}
