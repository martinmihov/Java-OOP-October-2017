package mood3;

public abstract class BaseGamePlayer implements GamePlayer {

    private String username;
    private String hashedPassword;
    private int level;

    protected BaseGamePlayer(String username, int level) {
        this.username = username;
        this.hashedPassword = generatePassword();
        this.level = level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected int getLevel() {
        return this.level;
    }

    protected abstract String generatePassword();

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n", this.username, this.hashedPassword, this.getClass().getSimpleName());
    }
}
