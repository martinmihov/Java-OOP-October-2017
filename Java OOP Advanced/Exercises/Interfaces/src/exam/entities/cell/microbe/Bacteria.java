package exam.entities.cell.microbe;

public class Bacteria extends Microbe {
    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        //-	Bacteria: energy = (health + virulence) / 3.
        return (this.getHealth() + this.getVirulence()) / 3;
    }

    @Override
    //--------Health {health} | Virulence {virulence} | Energy {energy}
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("--------Health: %d | Virulence: %d | Energy: %d",
                        this.getHealth(), this.getVirulence(), this.getEnergy()));
        return sb.toString();
    }
}
