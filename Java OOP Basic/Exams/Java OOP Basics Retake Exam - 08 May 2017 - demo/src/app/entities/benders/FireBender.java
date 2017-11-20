package app.entities.benders;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, long power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }
}
