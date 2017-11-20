package app.entities.benders;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, long power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }
}
