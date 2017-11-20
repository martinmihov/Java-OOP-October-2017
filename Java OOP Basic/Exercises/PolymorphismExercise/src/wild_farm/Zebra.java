package wild_farm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "Zs";
    }

    @Override
    public void eat(Food food, int foodsQuantity) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food, foodsQuantity);
    }
}
