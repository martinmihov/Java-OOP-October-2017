package tests;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public class ModuleContainerShould {
    private static final int CONTAINER_CAPACITY = 5;

    private Container container;
    private AbsorbingModule absorbingModuleMocked;
    private EnergyModule energyModuleMocked;

    @Before
    public void init() {
        this.container = new ModuleContainer(CONTAINER_CAPACITY);
        this.absorbingModuleMocked = mock(AbsorbingModule.class);
        this.energyModuleMocked = mock(EnergyModule.class);
    }

    @Test
    public void returnTotalEnergyOutputCorrectResult() {
        when(this.absorbingModuleMocked.getHeatAbsorbing()).thenReturn(10);
        this.container.addAbsorbingModule(this.absorbingModuleMocked);
        Assert.assertEquals("Incorrect HeatAbsorbing value", 10, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void returnTotalHeatAbsorbingCorrectResult() {
        when(this.energyModuleMocked.getEnergyOutput()).thenReturn(10);
        this.container.addEnergyModule(this.energyModuleMocked);
        Assert.assertEquals("Incorrect EnergyOutput value", 10, this.container.getTotalEnergyOutput());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenPassNullIntoAddEnergyModuleMethod() {
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenPassNullIntoAddAbsorbingModuleMethod() {
        this.container.addAbsorbingModule(null);
    }

    @Test
    public void returnLongValueOfEnergyOutput() {
        EnergyModule energyModuleMocked1 = mock(EnergyModule.class);
        EnergyModule energyModuleMocked2 = mock(EnergyModule.class);
        when(this.energyModuleMocked.getEnergyOutput()).thenReturn(1000000000);
        when(this.energyModuleMocked.getId()).thenReturn(1);
        when(energyModuleMocked1.getEnergyOutput()).thenReturn(1000000000);
        when(energyModuleMocked1.getId()).thenReturn(2);
        when(energyModuleMocked2.getEnergyOutput()).thenReturn(1000000000);
        when(energyModuleMocked2.getId()).thenReturn(3);
        this.container.addEnergyModule(this.energyModuleMocked);
        this.container.addEnergyModule(energyModuleMocked1);
        this.container.addEnergyModule(energyModuleMocked2);
        Assert.assertEquals("Incorrect Energy Output value", 3000000000L, this.container.getTotalEnergyOutput());
    }

    @Test
    public void returnLongValueOfHeatAbsorbing() {
        AbsorbingModule absorbingModuleMocked1 = mock(AbsorbingModule.class);
        AbsorbingModule absorbingModuleMocked2 = mock(AbsorbingModule.class);
        when(this.absorbingModuleMocked.getHeatAbsorbing()).thenReturn(1000000000);
        when(this.absorbingModuleMocked.getId()).thenReturn(1);
        when(absorbingModuleMocked1.getHeatAbsorbing()).thenReturn(1000000000);
        when(absorbingModuleMocked1.getId()).thenReturn(2);
        when(absorbingModuleMocked2.getHeatAbsorbing()).thenReturn(1000000000);
        when(absorbingModuleMocked2.getId()).thenReturn(3);
        this.container.addAbsorbingModule(this.absorbingModuleMocked);
        this.container.addAbsorbingModule(absorbingModuleMocked1);
        this.container.addAbsorbingModule(absorbingModuleMocked2);
        Assert.assertEquals("Incorrect Heat Absorbing value", 3000000000L, this.container.getTotalHeatAbsorbing());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void removeCurrentModuleAfterFullCapacityInEnergyModulesAndAbsorbingModules() throws NoSuchFieldException, IllegalAccessException {
        EnergyModule energyModuleMocked1 = mock(EnergyModule.class);
        EnergyModule energyModuleMocked2 = mock(EnergyModule.class);
        EnergyModule energyModuleMocked3 = mock(EnergyModule.class);
        EnergyModule energyModuleMocked4 = mock(EnergyModule.class);
        EnergyModule energyModuleMocked5 = mock(EnergyModule.class);
        EnergyModule energyModuleMocked6 = mock(EnergyModule.class);

        AbsorbingModule absorbingModule1 = mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule2 = mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule3 = mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule4 = mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule5 = mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule6 = mock(AbsorbingModule.class);

        when(energyModuleMocked1.getId()).thenReturn(1);
        when(energyModuleMocked2.getId()).thenReturn(2);
        when(energyModuleMocked3.getId()).thenReturn(3);
        when(energyModuleMocked4.getId()).thenReturn(4);
        when(energyModuleMocked5.getId()).thenReturn(5);
        when(energyModuleMocked6.getId()).thenReturn(6);

        when(absorbingModule1.getId()).thenReturn(7);
        when(absorbingModule2.getId()).thenReturn(8);
        when(absorbingModule3.getId()).thenReturn(9);
        when(absorbingModule4.getId()).thenReturn(10);
        when(absorbingModule5.getId()).thenReturn(11);
        when(absorbingModule6.getId()).thenReturn(12);

        this.container.addEnergyModule(energyModuleMocked1);
        this.container.addEnergyModule(energyModuleMocked2);
        this.container.addEnergyModule(energyModuleMocked3);
        this.container.addEnergyModule(energyModuleMocked4);
        this.container.addEnergyModule(energyModuleMocked5);
        this.container.addEnergyModule(energyModuleMocked6);

        Field fieldEnergy = this.container.getClass().getDeclaredField("energyModules");
        fieldEnergy.setAccessible(true);
        Map<Integer, EnergyModule> energyMap = (Map<Integer, EnergyModule>) fieldEnergy.get(this.container);

        Assert.assertEquals("Incorrect size of modules", CONTAINER_CAPACITY, energyMap.size());

        this.container.addAbsorbingModule(absorbingModule1);
        this.container.addAbsorbingModule(absorbingModule2);
        this.container.addAbsorbingModule(absorbingModule3);
        this.container.addAbsorbingModule(absorbingModule4);
        this.container.addAbsorbingModule(absorbingModule5);
        this.container.addAbsorbingModule(absorbingModule6);

        Field fieldAbsorbing = this.container.getClass().getDeclaredField("absorbingModules");
        fieldAbsorbing.setAccessible(true);
        Map<Integer, AbsorbingModule> absorbingMap = (Map<Integer, AbsorbingModule>) fieldAbsorbing.get(this.container);

        Assert.assertEquals("Incorrect size of modules", CONTAINER_CAPACITY, absorbingMap.size());
    }
}