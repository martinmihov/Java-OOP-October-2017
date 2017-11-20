package avatar.entities.races;

import avatar.entities.cars.Car;

public class DriftRace extends Race {

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public int calculatePoints(Car car) {
        return car.getSuspension() + car.getDurability();
    }
}
