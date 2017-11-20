package app.entities.cells;

public abstract class Microbe extends Cell {

    private int virulence;

    protected Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    protected int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Virulence: %d | Energy: %d",super.toString(), super.getHealth(), this.virulence, this.getEnergy());
    }
}
