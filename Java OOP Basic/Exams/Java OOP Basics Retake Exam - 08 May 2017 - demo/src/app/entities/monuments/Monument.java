package app.entities.monuments;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public abstract class Monument {
    private String name;

    protected Monument(String name) {
        this.name = name;
    }
}
