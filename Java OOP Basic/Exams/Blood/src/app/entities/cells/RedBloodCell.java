package app.entities.cells;

public class RedBloodCell extends BloodCell {

    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Velocity: %d | Energy: %d",super.toString(), super.getHealth(), this.velocity, this.getEnergy());
    }
}
