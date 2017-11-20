package avatar.entities.races;

import avatar.entities.cars.Car;

import java.util.HashMap;
import java.util.Map;

public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    private void decreaseDurability() {
        super.getParticipants().forEach(c -> c.decreaseDurability(this.laps, super.getLength()));
    }

    private Map<Integer, Car> getWinners() {
        Map<Integer, Car> winners = new HashMap<>();
        final int[] position = {1};

        super.getParticipants()
                .stream()
                .sorted((c1, c2) -> Integer.compare(this.calculatePoints(c2), this.calculatePoints(c1))).limit(4)
                .forEach(c ->
                        winners.putIfAbsent(position[0]++, c));
        this.decreaseDurability();

        return winners;
    }

    @Override
    protected int calculatePoints(Car car) {
        return (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", super.getRoute(), (super.getLength() * this.laps))).append(System.lineSeparator());
        for (Map.Entry<Integer, Car> carEntry : this.getWinners().entrySet()) {
            int position = carEntry.getKey();
            Car car = carEntry.getValue();
            int prize = getPrize(position);
            sb
                    .append(String.format("%d. %s %s %dPP - $%d", position, car.getBrand(), car.getModel(), this.calculatePoints(car), prize))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private int getPrize(int position) {
        switch (position) {
            case 1:
                return (super.getPrizePool() * 40) / 100;
            case 2:
                return (super.getPrizePool() * 30) / 100;
            case 3:
                return (super.getPrizePool() * 20) / 100;
            case 4:
                return (super.getPrizePool() * 10) / 100;
            default:
                return 0;
        }
    }
}
