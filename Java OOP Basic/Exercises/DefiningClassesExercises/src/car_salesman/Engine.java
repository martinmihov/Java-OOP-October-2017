package car_salesman;

public class Engine {
    private String model;
    private double power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, double power) {
        this.model = model;
        this.power = power;
        this.efficiency = GlobalConstants.DEFAULT_VALUE;
    }

    public Engine(String model, double power, Integer displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, double power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, double power, Integer displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.model + ":").append(System.lineSeparator());
        sb.append(String.format("\tPower: %.0f", this.power)).append(System.lineSeparator())
                .append(String.format("\tDisplacement: %s", this.displacement == null ? GlobalConstants.DEFAULT_VALUE : this.displacement)).append(System.lineSeparator())
                .append(String.format("\tEfficiency: %s", this.efficiency));

        return sb.toString();
    }
}
