package hell.factories;

import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public final class ItemFactory {
    private ItemFactory() {}

    public static Item makeCommonItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPoints, int damageBonus) {
        return new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPoints, damageBonus);
    }

    public static Recipe makeRecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPoints, int damageBonus, String... requiredItems) {
        return new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPoints, damageBonus, requiredItems);
    }
}
