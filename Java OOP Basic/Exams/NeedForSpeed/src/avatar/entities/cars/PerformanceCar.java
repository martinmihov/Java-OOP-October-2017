package avatar.entities.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void tuneCar(int index, String addOn) {
        this.addOns.add(addOn);
        super.tuneCar(index, addOn);
    }

    @Override
    protected void setHorsepower(int horsepower) {
        int increaseHorsepower = horsepower + ((horsepower * 50) / 100);
        super.setHorsepower(increaseHorsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        int decreaseSuspension = suspension - ((suspension * 25) / 100);
        super.setSuspension(decreaseSuspension);
    }

    @Override
    public String toString() {
        return String.format("%sAdd-ons: %s", super.toString(), this.addOns.size() == 0 ? "None" : String.join(", ", this.addOns));
    }
}