package cresla.factories;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.enums.ReactorType;
import cresla.interfaces.Reactor;

import static cresla.utilities.Constants.ID_GENERATOR;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public final class ReactorFactory {
    private ReactorFactory() {
    }

    public static Reactor createReactor(String type, int additionalParameter, int moduleCapacity) {
        switch (ReactorType.valueOf(type.toUpperCase())) {
            case CRYO:
                return new CryoReactor(ID_GENERATOR.getId(), additionalParameter, new ModuleContainer(moduleCapacity));
            case HEAT:
                return new HeatReactor(ID_GENERATOR.getId(), additionalParameter, new ModuleContainer(moduleCapacity));
            default:
                return null;
        }
    }
}
