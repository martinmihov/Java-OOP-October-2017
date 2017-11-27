package traffic.lights.enums;

public enum TrafficLight {
    RED, GREEN, YELLOW;

    private static TrafficLight[] vals = values();

    public TrafficLight next() {
        System.out.println(0%3);
        return vals[(this.ordinal() + 1) % vals.length];
    }
}
