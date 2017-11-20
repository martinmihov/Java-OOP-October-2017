package app.entities.cells;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public abstract int getEnergy();

    public int getHealth() {
        return this.health;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]%n", this.id, this.positionRow, this.positionCol);
    }
}
