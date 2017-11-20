package mordors_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] foodTokens = bufferedReader.readLine().split("\\s+");

        List<Food> foods = new ArrayList<>();

        for (String foodToken : foodTokens) {
            foods.add(FoodFactory.getFood(foodToken));
        }

        final int[] pointsAllFoods = {0};
        foods.forEach(x -> pointsAllFoods[0] += x.getPoints());
        String mood = MoodFactory.getMoodName(pointsAllFoods[0]);

        System.out.println(String.format("%d%n%s", pointsAllFoods[0], mood));
    }
}
