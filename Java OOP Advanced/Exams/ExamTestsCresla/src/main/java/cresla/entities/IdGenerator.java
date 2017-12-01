package cresla.entities;

import cresla.interfaces.Identifiable;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public class IdGenerator implements Identifiable {
    private volatile int id;

    public IdGenerator() {
        this.id = 0;
    }

    @Override
    public int getId() { return ++id; }
}