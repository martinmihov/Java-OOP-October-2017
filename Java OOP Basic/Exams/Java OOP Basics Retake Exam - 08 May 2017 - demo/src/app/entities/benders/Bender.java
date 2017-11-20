package app.entities.benders;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public abstract class Bender {
    private String name;
    private long power;

    protected Bender(String name, long power) {
        this.name = name;
        this.power = power;
    }
}
