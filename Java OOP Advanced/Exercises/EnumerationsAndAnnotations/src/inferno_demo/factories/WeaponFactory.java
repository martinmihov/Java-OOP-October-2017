package inferno_demo.factories;

import inferno_demo.models.api.WeaponInterface;
import inferno_demo.models.impl.Axe;
import inferno_demo.models.impl.Knife;
import inferno_demo.models.impl.Sword;

public final class WeaponFactory {
    private WeaponFactory() {
    }

    public static WeaponInterface createAxeWeapon(String name) {
        return new Axe(name);
    }

    public static WeaponInterface createSwordWeapon(String name) {
        return new Sword(name);
    }

    public static WeaponInterface createKnifeWeapon(String name) {
        return new Knife(name);
    }
}
