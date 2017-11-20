package app.entities.benders;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, long power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }
}
