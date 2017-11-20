package app.entities.monuments;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class EarthMonument extends Monument {
    private long earthAffinity;

    public EarthMonument(String name, long earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }
}
