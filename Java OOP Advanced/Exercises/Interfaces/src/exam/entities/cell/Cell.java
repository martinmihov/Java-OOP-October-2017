package exam.entities.cell;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.setId(id);
        this.setHealth(health);
        this.setPositionRow(positionRow);
        this.setPositionCol(positionCol);
    }

    public String getId() {
        return this.id;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    private void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    private void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public abstract int getEnergy();

    public void addHealth(int health) {
        this.health += health;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
    }

    public void changePositionRow(int row) {
        this.positionRow = row;
    }

    public void changePositionCol(int col) {
        this.positionCol = col;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]",
                this.getId(), this.getPositionRow(), this.getPositionCol());
    }
}




