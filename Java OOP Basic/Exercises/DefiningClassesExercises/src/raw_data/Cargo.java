package raw_data;

public class Cargo {
    private double weight;
    private String type;

    public Cargo(double weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
