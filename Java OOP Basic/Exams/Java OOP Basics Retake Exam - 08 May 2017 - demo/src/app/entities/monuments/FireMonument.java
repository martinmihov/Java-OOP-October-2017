package app.entities.monuments;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class FireMonument extends Monument {
    private long fireAffinity;

    public FireMonument(String name, long fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }
}
