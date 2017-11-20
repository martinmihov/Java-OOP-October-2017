package class_box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Surface Area - %.2f%n", this.getSurfaceArea()))
                .append(String.format("Lateral Surface Area - %.2f%n", this.getLateralSurfaceArea()))
                .append(String.format("Volume - %.2f%n", this.getVolume()));

        return sb.toString();
    }

    private double getVolume() {
        return this.length * this.width * this.height;
    }

    private double getLateralSurfaceArea() {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    private double getSurfaceArea() {
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }
}
