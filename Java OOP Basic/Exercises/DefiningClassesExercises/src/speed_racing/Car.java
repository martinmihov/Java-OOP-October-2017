package speed_racing;

public class Car {
    private static final double DEFAULT_TRAVELLED_DISTANCE = 0;

    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private double travelledDistance;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.travelledDistance = DEFAULT_TRAVELLED_DISTANCE;
    }

    public String getModel() {
        return this.model;
    }

    public void drive(double amountOfKilometers) {
        double costDistance = amountOfKilometers * this.fuelCostPerKilometer;
        if (costDistance > fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
            return;
        }
        this.fuelAmount -= costDistance;
        this.travelledDistance += amountOfKilometers;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.travelledDistance);
    }
}