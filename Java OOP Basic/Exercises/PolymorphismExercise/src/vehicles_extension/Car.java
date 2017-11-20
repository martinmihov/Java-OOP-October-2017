package vehicles_extension;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        double summerFuelConsumption = fuelConsumptionInLitersPerKm + 0.9;
        super.setFuelConsumptionInLitersPerKm(summerFuelConsumption);
    }
}