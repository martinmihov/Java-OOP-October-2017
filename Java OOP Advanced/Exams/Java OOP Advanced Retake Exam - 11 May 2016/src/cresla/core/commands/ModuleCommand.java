package cresla.core.commands;

import cresla.annotations.Inject;
import cresla.core.Executable;
import cresla.enums.ModuleType;
import cresla.factories.ModuleFactory;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.OutputWriter;
import cresla.repositories.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public class ModuleCommand implements Executable {
    @Inject
    private List<String> params;
    @Inject
    private OutputWriter writer;
    @Inject
    private Repository repository;

    @Override
    public void execute() throws IllegalAccessException {
        int id = Integer.parseInt(this.params.get(1));
        AbsorbingModule absorbingModule = null;
        EnergyModule energyModule = null;
        switch (ModuleType.valueOf(this.params.get(2).toUpperCase())) {
            case CRYOGENROD:
                energyModule = ModuleFactory.createEnergyModule(Integer.parseInt(this.params.get(3)));
                this.repository.getReactorById(id).addEnergyModule(energyModule);
                this.repository.addIdentifiable(energyModule);
                break;
            case HEATPROCESSOR:
                absorbingModule = ModuleFactory.createAbsorbingModule(this.params.get(2), Integer.parseInt(this.params.get(3)));
                this.repository.getReactorById(id).addAbsorbingModule(absorbingModule);
                this.repository.addIdentifiable(absorbingModule);
                break;
            case COOLDOWNSYSTEM:
                absorbingModule = ModuleFactory.createAbsorbingModule(this.params.get(2), Integer.parseInt(this.params.get(3)));
                this.repository.getReactorById(id).addAbsorbingModule(absorbingModule);
                this.repository.addIdentifiable(absorbingModule);
                break;
        }
        this.writer.writeLine(String.format("Added %s - %d to Reactor - %d", this.params.get(2), absorbingModule == null ? energyModule.getId() : absorbingModule.getId(), id));
    }
}
