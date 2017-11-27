package inferno_demo.models.impl;

import inferno_demo.enumerations.WeaponTypes;

public class Knife extends Weapon {
    public Knife(String name) {
        super(name, WeaponTypes.KNIFE.getMinDamage(), WeaponTypes.KNIFE.getMaxDamage(), WeaponTypes.KNIFE.getSockets());
    }
}
