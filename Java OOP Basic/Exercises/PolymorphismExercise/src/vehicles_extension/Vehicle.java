package vehicles_extension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.tankCapacity = tankCapacity;
        this.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm);
    }

    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public void driveEmpty(double distance) {
        double fuelNeedForDistance = this.fuelConsumptionInLitersPerKm * distance;
        if (this.fuelQuantity < fuelNeedForDistance) {
            throw new IllegalStateException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuelQuantity -= fuelNeedForDistance;
    }

    public void drive(double distance) {
        double fuelNeedForDistance = this.fuelConsumptionInLitersPerKm * distance;
        if (this.fuelQuantity < fuelNeedForDistance) {
            throw new IllegalStateException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuelQuantity -= fuelNeedForDistance;
    }

    public void refuel(double givenFuel) {
        if (givenFuel <= 0) {
            throw new IllegalStateException("Fuel must be a positive number");
        }
        if (this.tankCapacity - this.fuelQuantity < givenFuel) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += givenFuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}