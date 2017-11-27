package inferno_demo.models.impl;

import inferno_demo.enumerations.WeaponTypes;

public class Axe extends Weapon {
    public Axe(String name) {
        super(name, WeaponTypes.AXE.getMinDamage(), WeaponTypes.AXE.getMaxDamage(), WeaponTypes.AXE.getSockets());
    }
}
