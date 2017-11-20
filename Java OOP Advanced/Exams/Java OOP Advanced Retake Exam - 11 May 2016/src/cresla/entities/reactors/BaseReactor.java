package cresla.entities.reactors;

import cresla.annotations.ItemCollection;
import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public abstract class BaseReactor implements Reactor {
    private int id;
    private Container container;

    protected BaseReactor(int id, Container container) {
        this.id = id;
        this.container = container;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() throws IllegalAccessException {
        List<Module> items = new ArrayList<>();
        Field[] fields = this.container.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (List<Module>) field.get(this.container);
                break;
            }
        }
        return items.size();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format("%s - %d%s", this.getClass().getSimpleName(), this.id, System.lineSeparator()))
                    .append(String.format("Energy Output: %d%s", this.getTotalEnergyOutput() > this.getTotalHeatAbsorbing() ? 0 : this.getTotalEnergyOutput(), System.lineSeparator()))
                    .append(String.format("Heat Absorbing: %d%s", this.getTotalHeatAbsorbing(), System.lineSeparator()))
                    .append(String.format("Modules: %d", this.getModuleCount()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
