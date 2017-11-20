package exam.entities.cell.bloodCell;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.setSize(size);
    }

    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getEnergy() {
        //-	WhiteBloodCell: energy = (health + size) * 2.
        return (this.getHealth() + this.getSize()) * 2;
    }

    @Override
    public String toString() {
        //--------Health {health} | Size {size} | Energy {energy}
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("--------Health: %d | Size: %d | Energy: %d",
                        this.getHealth(), this.getSize(), this.getEnergy()));
        return sb.toString();
    }
}
