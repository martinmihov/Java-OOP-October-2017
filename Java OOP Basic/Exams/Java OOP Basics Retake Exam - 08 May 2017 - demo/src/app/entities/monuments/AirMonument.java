package app.entities.monuments;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class AirMonument extends Monument {
    private long airAffinity;

    public AirMonument(String name, long airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }
}
