package mordors_cruelty_plan;

public class Food {
    private String type;
    private int points;

    public Food(String type, int points) {
        this.type = type;
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }
}
