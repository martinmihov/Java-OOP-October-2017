package tests;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Hristo Skipernov on 11/05/2017.
 */
public class InventoryClassShould {
    private Inventory inventory;
    private Item mockedItem;
    private Recipe mockedRecipe;

    @Before
    public void initialize() throws IllegalAccessException {
        this.inventory = new HeroInventory();
        this.mockedItem = mock(Item.class);
        this.mockedRecipe = mock(Recipe.class);
    }

    @Test
    public void correctCombineItems() throws NoSuchFieldException, IllegalAccessException {
        when(this.mockedItem.getName()).thenReturn("Knife");
        when(this.mockedRecipe.getName()).thenReturn("Knife");
        this.inventory.addCommonItem(mockedItem);
        this.inventory.addRecipeItem(mockedRecipe);
        Assert.assertEquals(this.inventory.getTotalIntelligenceBonus(), mockedRecipe.getIntelligenceBonus());

    }

    @Test
    public void addingNewRecipeShouldIncreaseItemsSize() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addRecipeItem(this.mockedRecipe);
        Field field = this.inventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void addingNewCommonShouldIncreaseItemsSize() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addRecipeItem(this.mockedRecipe);
        Field field = this.inventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void strengthGetterShouldReturnCorrectResult() {
        when(this.mockedItem.getStrengthBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void agilityGetterShouldReturnCorrectResult() {
        when(this.mockedItem.getAgilityBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void intelligenceGetterShouldReturnCorrectResult() {
        when(this.mockedItem.getIntelligenceBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void hitPointsGetterShouldReturnCorrectResult() {
        when(this.mockedItem.getHitPointsBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void damageGetterShouldReturnCorrectResult() {
        when(this.mockedItem.getDamageBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalDamageBonus());
    }
}
