package vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;

    protected Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm);
    }

    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public void drive(Double distance) {
        double fuelNeedForDistance = this.fuelConsumptionInLitersPerKm * distance;
        if (this.fuelQuantity < fuelNeedForDistance) {
            throw new IllegalStateException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuelQuantity -= fuelNeedForDistance;
    }

    public void refuel(Double givenFuel) {
        this.fuelQuantity += givenFuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}