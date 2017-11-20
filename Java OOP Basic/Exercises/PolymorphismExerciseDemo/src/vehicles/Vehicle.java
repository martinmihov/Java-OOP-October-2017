package vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;

    protected Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public void drive(double distance) {
        double needFuel = this.fuelConsumptionInLitersPerKm * distance;
        if (needFuel > this.fuelQuantity) {
            throw new IllegalStateException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuelQuantity -= needFuel;
    }

    public void refuel(double litres) {
        this.fuelQuantity += litres;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}