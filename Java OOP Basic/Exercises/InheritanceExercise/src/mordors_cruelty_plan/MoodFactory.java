package mordors_cruelty_plan;

public abstract class MoodFactory {

    public static String getMoodName(int points) {
        if(points < -5) {
            return "Angry";
        } else if (points < 0) {
            return "Sad";
        } else if (points < 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }
}
