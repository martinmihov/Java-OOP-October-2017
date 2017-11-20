package app.entities.monuments;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class WaterMonument extends Monument {
    private long waterAffinity;

    public WaterMonument(String name, long waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }
}
