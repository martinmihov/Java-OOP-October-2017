package mordors_cruelty_plan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wizard {
    private static final Map<String, Integer> FOODS = new HashMap<String, Integer>() {{
        put("cram", 2);
        put("lembas", 3);
        put("apple", 1);
        put("melon", 1);
        put("honeycake", 5);
        put("mushrooms", -10);
    }};

    private int happinessIndex;

    public void setHappinessIndex(List<String> foods) {
        foods.forEach(this::eatFood);
    }

    public int getHappinessIndex() {
        return this.happinessIndex;
    }

    public String getMood() {
        if (this.happinessIndex < - 5) {
            return "Angry";
        } else if (this.happinessIndex <= 0) {
            return "Sad";
        } else if (this.happinessIndex <= 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }

    private void eatFood(String food) {
        String foodLowerName = food.toLowerCase();
        if (FOODS.containsKey(foodLowerName)) {
            this.happinessIndex += FOODS.get(foodLowerName);
            return;
        }
        this.happinessIndex -= 1;
    }
}
