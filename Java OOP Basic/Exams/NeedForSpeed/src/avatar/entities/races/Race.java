package avatar.entities.races;

import avatar.entities.cars.Car;

import java.util.*;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.participants.add(car);
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    protected int getLength() {
        return this.length;
    }

    protected int getPrizePool() {
        return this.prizePool;
    }

    protected String getRoute() {
        return this.route;
    }

    protected abstract int calculatePoints(Car car);

    private Map<Integer, Car> getWinners() {
        Map<Integer, Car> winners = new HashMap<>();
        final int[] position = {1};

        this.participants
                .stream()
                .sorted((c1, c2) -> Integer.compare(this.calculatePoints(c2), this.calculatePoints(c1))).limit(3)
                .forEach(c ->
                winners.putIfAbsent(position[0]++, c));

        return winners;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", this.route, this.length)).append(System.lineSeparator());
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
                return (this.prizePool * 50) / 100;
            case 2:
                return (this.prizePool * 30) / 100;
            case 3:
                return (this.prizePool * 20) / 100;
            default:
                return 0;
        }
    }
}
