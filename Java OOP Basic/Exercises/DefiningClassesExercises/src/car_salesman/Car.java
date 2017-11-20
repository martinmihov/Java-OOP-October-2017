package car_salesman;

public class Car {
    private String model;
    private Engine engine;
    private Integer weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.color = GlobalConstants.DEFAULT_VALUE;
    }

    public Car(String model, Engine engine, Integer weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, Integer weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.model + ":").append(System.lineSeparator());
        sb.append("\t" + this.engine).append(System.lineSeparator())
                .append(String.format("\tWeight: %s",this.weight == null ? GlobalConstants.DEFAULT_VALUE : this.weight)).append(System.lineSeparator())
                .append(String.format("\tColor: %s", this.color));

        return sb.toString();
    }
}
