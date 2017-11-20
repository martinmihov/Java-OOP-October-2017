package app.entities.benders;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, long power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }
}
