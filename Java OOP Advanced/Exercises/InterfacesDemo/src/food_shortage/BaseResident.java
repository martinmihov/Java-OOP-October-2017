package food_shortage;

public abstract class BaseResident implements Identifiable {
    private String id;

    protected BaseResident(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}