package cresla.entities.reactors;

import cresla.interfaces.Container;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public class CryoReactor extends BaseReactor {
    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex, Container container) {
        super(id, container);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput() * this.cryoProductionIndex;
    }
}
