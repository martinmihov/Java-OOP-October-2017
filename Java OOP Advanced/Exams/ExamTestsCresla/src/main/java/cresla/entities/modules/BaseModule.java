package cresla.entities.modules;

import cresla.interfaces.Module;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public abstract class BaseModule implements Module {
    private int id;

    protected BaseModule(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
