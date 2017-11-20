package cresla.entities.reactors;

import cresla.interfaces.Container;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public class HeatReactor extends BaseReactor {
    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex, Container container) {
        super(id, container);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + this.heatReductionIndex;
    }
}
