package raw_data;

public class Engine {
    private double speed;
    private double power;

    public Engine(double speed, double power) {
        this.speed = speed;
        this.power = power;
    }

    public double getPower() {
        return this.power;
    }
}
