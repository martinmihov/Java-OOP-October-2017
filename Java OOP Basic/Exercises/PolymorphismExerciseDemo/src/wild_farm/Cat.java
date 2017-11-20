package wild_farm;

import static wild_farm.Main.DECIMAL_FORMAT;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food, int foodQuantity) {
        this.setFoodEaten(foodQuantity);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(), super.getAnimalName(), this.breed, DECIMAL_FORMAT.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}
