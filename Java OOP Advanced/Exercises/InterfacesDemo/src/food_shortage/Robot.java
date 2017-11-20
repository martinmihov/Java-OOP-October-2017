package food_shortage;

public class Robot extends BaseResident {

    private String model;

    public Robot(String model, String id) {
        super(id);
        this.model = model;
    }
}
