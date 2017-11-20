package mood3;

public class Demon extends BaseGamePlayer {

    private double energy;

    public Demon(String username, int level, double energy) {
        super(username, level);
        this.energy = energy;
    }

    @Override
    public String generatePassword() {
        return String.valueOf(super.getUsername().length() * 217);
    }

    @Override
    public String toString() {
        return super.toString() + (this.energy * super.getLevel());
    }
}
