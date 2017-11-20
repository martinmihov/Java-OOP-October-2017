package border_control;

public abstract class Resident implements Identifiable {

    private String id;

    protected Resident(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
