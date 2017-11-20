package cresla.factories;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.enums.ModuleType;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;

import static cresla.utilities.Constants.ID_GENERATOR;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public final class ModuleFactory {
    private ModuleFactory() {
    }

    public static EnergyModule createEnergyModule(int additionalParameter) {
        return new CryogenRod(ID_GENERATOR.getId(), additionalParameter);
    }

    public static AbsorbingModule createAbsorbingModule(String type, int additionalParameter) {
        switch (ModuleType.valueOf(type.toUpperCase())) {
            case HEATPROCESSOR:
                return new HeatProcessor(ID_GENERATOR.getId(), additionalParameter);
            case COOLDOWNSYSTEM:
                return new CooldownSystem(ID_GENERATOR.getId(), additionalParameter);
            default:
                return null;
        }
    }
}
