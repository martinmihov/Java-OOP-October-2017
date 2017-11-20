package vehicles_extension;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        double summerFuelConsumption = fuelConsumptionInLitersPerKm + 1.6;
        super.setFuelConsumptionInLitersPerKm(summerFuelConsumption);
    }

    @Override
    public void refuel(double givenFuel) {
        double truckRefuelQuantity = givenFuel * 0.95;
        super.refuel(truckRefuelQuantity);
    }
}