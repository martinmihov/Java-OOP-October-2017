package hell.entities.heroes;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public abstract class BaseHero implements Hero {
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    protected BaseHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() throws IllegalAccessException {
        Map<String, Item> items = null;
        Field[] fields = this.inventory.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (Map<String, Item>) field.get(this.inventory);
            }
        }
        return items != null ? items.values() : null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder sb = null;
        try {
            sb = new StringBuilder()
                    .append(String.format("Hero: %s, Class: %s%s", this.getName(), this.getClass().getSimpleName(), System.lineSeparator()))
                    .append(String.format("HitPoints: %d, Damage: %d%s", this.getHitPoints(), this.getDamage(), System.lineSeparator()))
                    .append(String.format("Strength: %d%s", this.getStrength(), System.lineSeparator()))
                    .append(String.format("Agility: %d%s", this.getAgility(), System.lineSeparator()))
                    .append(String.format("Intelligence: %d%s", this.getIntelligence(), System.lineSeparator()));
            if (this.getItems().isEmpty()) {
                sb.append("Items: None");
            } else {
                sb.append("Items: ").append(System.lineSeparator());
                for (Item item : this.getItems()) {
                    sb.append(String.format("###Item: %s%s", item.getName(), System.lineSeparator()))
                            .append(String.format("###+%d Strength%s", item.getStrengthBonus(), System.lineSeparator()))
                            .append(String.format("###+%d Agility%s", item.getAgilityBonus(), System.lineSeparator()))
                            .append(String.format("###+%d Intelligence%s", item.getIntelligenceBonus(), System.lineSeparator()))
                            .append(String.format("###+%d HitPoints%s", item.getHitPointsBonus(), System.lineSeparator()))
                            .append(String.format("###+%d Damage%s", item.getDamageBonus(), System.lineSeparator()));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sb.toString().trim();
    }
}
