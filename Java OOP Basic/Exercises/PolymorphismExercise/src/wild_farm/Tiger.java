package wild_farm;

public class Tiger extends Felime {
    private String region;

    public Tiger(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.region = livingRegion;
    }

    @Override
    protected String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food, int foodsQuantity) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food, foodsQuantity);
    }
}
