package hell.factories;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public final class InventoryFactory {
    private InventoryFactory() {
    }

    public static Inventory makeInventory() {
        return new HeroInventory();
    }
}
