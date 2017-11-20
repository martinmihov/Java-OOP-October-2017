package mordors_cruelty_plan;

public abstract class FoodFactory {
    private static final int CRAM_POINTS = 2;
    private static final int LEMBAS_POINTS = 3;
    private static final int APPLE_POINTS = 1;
    private static final int MELON_POINTS = 1;
    private static final int HONEYCAKE_POINTS = 5;
    private static final int MUSHROOMS_POINTS = -10;
    private static final int EVERYTHING_ELSE_FOOD_POINTS = -1;

    public static Food getFood(String type) {
        Food food;
        switch (type.toLowerCase()) {
            case "cram":
                food = new Food(type, CRAM_POINTS);
                return food;
            case "lembas":
                food = new Food(type, LEMBAS_POINTS);
                return food;
            case "apple":
                food = new Food(type, APPLE_POINTS);
                return food;
            case "melon":
                food = new Food(type, MELON_POINTS);
                return food;
            case "honeycake":
                food = new Food(type, HONEYCAKE_POINTS);
                return food;
            case "mushrooms":
                food = new Food(type, MUSHROOMS_POINTS);
                return food;
            default:
                food = new Food(type, EVERYTHING_ELSE_FOOD_POINTS);
                return food;
        }
    }
}
