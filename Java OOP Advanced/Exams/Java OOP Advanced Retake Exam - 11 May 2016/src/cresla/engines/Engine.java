package cresla.engines;

import cresla.enums.ModuleType;
import cresla.enums.ReactorType;
import cresla.factories.ModuleFactory;
import cresla.factories.ReactorFactory;
import cresla.interfaces.*;
import cresla.repositories.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "Exit";
    //private static final String COMMAND_CLASS_PATH = "cresla.core.commands.";
    //private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private static final String ENERGY_OUTPUT = "Energy Output";
    private static final String HEAT_ABSORBING = "Heat Absorbing";

    //private List<String> params;
    private InputReader reader;
    private OutputWriter writer;
    private Repository repository;

    public Engine(InputReader reader, OutputWriter writer, Repository repository) {
        this.reader = reader;
        this.writer = writer;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));
            try {
                this.dispatchCommand(tokens.get(0), tokens);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        this.params= tokens;
//        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
//        Executable executable = commandClass.newInstance();
//        injectDependencies(executable);
//        executable.execute();

        switch (command) {
            case "Reactor":
                Reactor reactor = ReactorFactory.createReactor(tokens.get(1), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)));
                this.repository.addReactor(reactor);
                this.repository.addIdentifiable(reactor);
                this.writer.writeLine(String.format("Created %s Reactor - %d", tokens.get(1), reactor.getId()));
                break;
            case "Module":
                int id = Integer.parseInt(tokens.get(1));
                AbsorbingModule absorbingModule = null;
                EnergyModule energyModule = null;
                switch (ModuleType.valueOf(tokens.get(2).toUpperCase())) {
                    case CRYOGENROD:
                        energyModule = ModuleFactory.createEnergyModule(Integer.parseInt(tokens.get(3)));
                        this.repository.getReactorById(id).addEnergyModule(energyModule);
                        this.repository.addIdentifiable(energyModule);
                        break;
                    case HEATPROCESSOR:
                        absorbingModule = ModuleFactory.createAbsorbingModule(tokens.get(2), Integer.parseInt(tokens.get(3)));
                        this.repository.getReactorById(id).addAbsorbingModule(absorbingModule);
                        this.repository.addIdentifiable(absorbingModule);
                        break;
                    case COOLDOWNSYSTEM:
                        absorbingModule = ModuleFactory.createAbsorbingModule(tokens.get(2), Integer.parseInt(tokens.get(3)));
                        this.repository.getReactorById(id).addAbsorbingModule(absorbingModule);
                        this.repository.addIdentifiable(absorbingModule);
                        break;
                }
                this.writer.writeLine(String.format("Added %s - %d to Reactor - %d", tokens.get(2), absorbingModule == null ? energyModule.getId() : absorbingModule.getId(), id));
                break;
            case "Report":
                this.writer.writeLine(this.repository.getIdentifiableById(Integer.parseInt(tokens.get(1))).toString());
                break;
            case "Exit":
                StringBuilder sb = new StringBuilder()
                        .append(String.format("Cryo Reactors: %d%s", this.repository.getReactors().values().stream().filter(x -> x.getClass().getSimpleName().toUpperCase().contains(ReactorType.CRYO.toString())).count(), System.lineSeparator()))
                        .append(String.format("Heat Reactors: %d%s", this.repository.getReactors().values().stream().filter(x -> x.getClass().getSimpleName().toUpperCase().contains(ReactorType.HEAT.toString())).count(), System.lineSeparator()))
                        .append(String.format("Energy Modules: %d%s", this.repository.getIdentifiables().values().stream().map(x -> x.getClass().getSuperclass().getInterfaces()).filter(x -> x.length > 0).map(x -> x[0].getSimpleName()).filter(x -> x.equals("EnergyModule")).count(), System.lineSeparator()))
                        .append(String.format("Absorbing Modules: %d%s", this.repository.getIdentifiables().values().stream().map(x -> x.getClass().getSuperclass().getInterfaces()).filter(x -> x.length > 0).map(x -> x[0].getSimpleName()).filter(x -> x.equals("AbsorbingModule")).count(), System.lineSeparator()))
                        .append(String.format("Total Energy Output: %d%s", this.repository.getReactors().values().stream().mapToLong(x -> x.getTotalEnergyOutput() > x.getTotalHeatAbsorbing() ? 0 : x.getTotalEnergyOutput()).sum(), System.lineSeparator()))
                        .append(String.format("Total Heat Absorbing: %d", this.repository.getReactors().values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum()));
                this.writer.writeLine(sb.toString());
                break;
        }
    }

//    private void injectDependencies(Executable executable) throws IllegalAccessException {
//        Field[] fields = executable.getClass().getDeclaredFields();
//
//        for (Field field : fields) {
//            if (field.isAnnotationPresent(Inject.class)) {
//                Field[] currentFields = this.getClass().getDeclaredFields();
//                for (Field currentField : currentFields) {
//                    if (field.getType().equals(currentField.getType())) {
//                        field.setAccessible(true);
//                        field.set(executable, currentField.get(this));
//                    }
//                }
//            }
//        }
//    }
}
