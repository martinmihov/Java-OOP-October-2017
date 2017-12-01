package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public abstract class BaseEnergyModule extends BaseModule implements EnergyModule {
    private static final String ENERGY_OUTPUT = "Energy Output";

    private int energyOutput;

    protected BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("%s Module - %d%s", this.getClass().getSimpleName(), super.getId(), System.lineSeparator()))
                .append(String.format("%s: %d", ENERGY_OUTPUT, this.getEnergyOutput()))
                .toString();
    }
}
