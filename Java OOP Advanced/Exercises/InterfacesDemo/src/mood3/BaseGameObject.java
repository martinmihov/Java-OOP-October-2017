package mood3;

public abstract class BaseGameObject implements GameObject {
    private String username;
    private String hashedPassword;
    private int level;

    protected BaseGameObject(String username, int level) {
        this.username = username;
        this.hashedPassword = this.generateHashPassword();
        this.level = level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected int getLevel() {
        return this.level;
    }

    protected abstract String generateHashPassword();

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n", this.username, this.hashedPassword, this.getClass().getSimpleName());
    }
}
