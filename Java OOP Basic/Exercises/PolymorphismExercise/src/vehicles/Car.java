package vehicles;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        double summerFuelConsumption = fuelConsumptionInLitersPerKm + 0.9;
        super.setFuelConsumptionInLitersPerKm(summerFuelConsumption);
    }
}
