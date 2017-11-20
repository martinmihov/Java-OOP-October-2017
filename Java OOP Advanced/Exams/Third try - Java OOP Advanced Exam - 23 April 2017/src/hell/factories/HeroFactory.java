package hell.factories;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public final class HeroFactory {
    private static final String BARBARIAN = "Barbarian";
    private static final String ASSASSIN = "Assassin";
    private static final String WIZARD = "Wizard";

    private HeroFactory() {
    }

    public static Hero makeHero(String name, String type) {
        switch (type) {
            case BARBARIAN:
                return new Barbarian(name, InventoryFactory.makeInventory());
            case ASSASSIN:
                return new Assassin(name, InventoryFactory.makeInventory());
            case WIZARD:
                return new Wizard(name, InventoryFactory.makeInventory());
            default:
                return null;
        }
    }
}
