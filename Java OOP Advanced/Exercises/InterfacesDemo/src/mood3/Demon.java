package mood3;

public class Demon extends BaseGameObject {

    private double energy;

    public Demon(String username, int level, double energy) {
        super(username, level);
        this.energy = energy;
    }

    @Override
    protected String generateHashPassword() {
        return String.valueOf(super.getUsername().length() * 217);
    }

    @Override
    public String toString() {
        return String.format("%s%s", super.toString(), (this.energy * super.getLevel()));
    }
}
