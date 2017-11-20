package vehicles;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        double summerFuelConsumption = fuelConsumptionInLitersPerKm + 1.6;
        super.setFuelConsumptionInLitersPerKm(summerFuelConsumption);
    }

    @Override
    public void refuel(Double givenFuel) {
        double truckRefuelQuantity = givenFuel * 0.95;
        super.refuel(truckRefuelQuantity);
    }
}