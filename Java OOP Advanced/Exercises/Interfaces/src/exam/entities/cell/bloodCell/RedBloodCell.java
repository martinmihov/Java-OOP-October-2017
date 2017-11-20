package exam.entities.cell.bloodCell;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.setVelocity(velocity);
    }

    public int getVelocity() {
        return this.velocity;
    }

    private void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public int getEnergy() {
        //-	RedBloodCell: energy = health + velocity.
        return this.getHealth() + this.getVelocity();
    }

    @Override
    //--------Health {health} | Velocity {velocity} | Energy {energy}
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("--------Health: %d | Velocity: %d | Energy: %d",
                        this.getHealth(), this.getVelocity(), this.getEnergy()));
        return sb.toString();
    }
}
