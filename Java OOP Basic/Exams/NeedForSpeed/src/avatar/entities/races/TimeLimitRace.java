package avatar.entities.races;

import avatar.entities.cars.Car;

public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    protected int calculatePoints(Car car) {
        int points = super.getLength() * ((car.getHorsepower() / 100) * car.getAcceleration());
        return points;
    }

    @Override
    public String toString() {
        Car car = super.getParticipants().get(0);
        int points = this.calculatePoints(car);
        String earnedTime;
        int prize;
        if (points <= this.goldTime) {
            earnedTime = "Gold";
            prize = super.getPrizePool();
        } else if (points <= this.goldTime + 15) {
            earnedTime = "Silver";
            prize = (super.getPrizePool() * 50) / 100;
        } else {
            earnedTime = "Bronze";
            prize = (super.getPrizePool() * 30) / 100;
        }
        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format("%s - %s", super.getRoute(), super.getLength()))
                .append(System.lineSeparator())
                .append(String.format("%s %s - %d s.", car.getBrand(), car.getModel(), points))
                .append(System.lineSeparator())
                .append(String.format("%s Time, $%d.", earnedTime, prize));
        return sb.toString();
    }
}
