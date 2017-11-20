package mood3;

public class Archangel extends BaseGamePlayer {

    private int mana;

    public Archangel(String username, int level, int mana) {
        super(username, level);
        this.mana = mana;
    }

    @Override
    public String generatePassword() {
        return new StringBuilder(super.getUsername()).reverse().toString() + (super.getUsername().length() * 21);
    }

    @Override
    public String toString() {
        return super.toString() + (this.mana * super.getLevel());
    }
}
