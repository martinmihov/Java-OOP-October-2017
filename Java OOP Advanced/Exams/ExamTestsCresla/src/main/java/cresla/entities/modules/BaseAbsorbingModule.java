package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public abstract class BaseAbsorbingModule extends BaseModule implements AbsorbingModule {
    private static final String HEAT_ABSORBING = "Heat Absorbing";

    private int heatAbsorbing;

    protected BaseAbsorbingModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("%s Module - %d%s", this.getClass().getSimpleName(), super.getId(), System.lineSeparator()))
                .append(String.format("%s: %d", HEAT_ABSORBING, this.getHeatAbsorbing()))
                .toString();
    }
}
