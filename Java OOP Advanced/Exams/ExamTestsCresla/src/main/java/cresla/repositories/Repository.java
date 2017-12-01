package cresla.repositories;

import cresla.interfaces.Identifiable;
import cresla.interfaces.Reactor;

import java.util.Map;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public interface Repository {

    void addReactor(Reactor reactor);

    void addIdentifiable(Identifiable identifiable);

    //void addEnergyModule(EnergyModule energyModule);

    //void addAbsorbingModule(AbsorbingModule absorbingModule);

    Map<Integer, Reactor> getReactors();

    Map<Integer, Identifiable> getIdentifiables();

    //Map<Integer, EnergyModule> getEnergyModules();

    //Map<Integer, AbsorbingModule> getAbsorbingModules();

    Reactor getReactorById(int id);

    Identifiable getIdentifiableById(int id);
}
