package cresla.core.commands;

import cresla.annotations.Inject;
import cresla.core.Executable;
import cresla.enums.ReactorType;
import cresla.interfaces.OutputWriter;
import cresla.interfaces.Reactor;
import cresla.repositories.Repository;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public class ExitCommand implements Executable {
    @Inject
    private OutputWriter writer;
    @Inject
    private Repository repository;

    @Override
    public void execute() throws IllegalAccessException {
        StringBuilder sb = new StringBuilder()
                .append(String.format("Cryo Reactors: %d%s", this.repository.getReactors().values().stream().filter(x -> x.getClass().getSimpleName().toUpperCase().contains(ReactorType.CRYO.toString())).count(), System.lineSeparator()))
                .append(String.format("Heat Reactors: %d%s", this.repository.getReactors().values().stream().filter(x -> x.getClass().getSimpleName().toUpperCase().contains(ReactorType.HEAT.toString())).count(), System.lineSeparator()))
                .append(String.format("Energy Modules: %d%s", this.repository.getIdentifiables().values().stream().map(x -> x.getClass().getInterfaces()).filter(x -> x.length > 0).map(x -> x[0].getName().equals("EnergyModule")).count(), System.lineSeparator()))
                .append(String.format("Absorbing Modules: %d%s", this.repository.getIdentifiables().values().stream().map(x -> x.getClass().getSuperclass().getInterfaces()).filter(x -> x.length > 0).map(x -> x[0].getSimpleName()).filter(x -> x.equals("AbsorbingModule")).count(), System.lineSeparator()))
                .append(String.format("Total Energy Output: %d%s", this.repository.getReactors().values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum(), System.lineSeparator()))
                .append(String.format("Total Heat Absorbing: %d", this.repository.getReactors().values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum()));
        this.writer.writeLine(sb.toString());
    }
}
