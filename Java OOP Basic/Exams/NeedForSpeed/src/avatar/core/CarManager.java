package avatar.core;

import avatar.entities.cars.Car;
import avatar.entities.garage.Garage;
import avatar.entities.races.Race;
import avatar.factories.CarFactory;
import avatar.factories.RaceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static avatar.utilities.Constants.*;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage(new ArrayList<>());
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;
        switch (type) {
            case PERFORMANCE_CAR_TYPE:
                car = CarFactory.createPerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case SHOW_CAR_TYPE:
                car = CarFactory.createShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }
        this.cars.putIfAbsent(id, car);
    }

    public String check(int id) {
        if (this.cars.containsKey(id)) {
            return this.cars.get(id).toString();
        }
        return null;
    }

    public void open(int id, String type, int length, String route, int prizePool, int... optionalParam) {
        Race race = null;
        switch (type) {
            case CASUAL_RACE_TYPE:
                race = RaceFactory.createCasualRace(length, route, prizePool);
                break;
            case DRIFT_RACE_TYPE:
                race = RaceFactory.createDriftRace(length, route, prizePool);
                break;
            case DRAG_RACE_TYPE:
                race = RaceFactory.createDragRace(length, route, prizePool);
                break;
            case TIME_LIMIT_RACE_TYPE:
                race = RaceFactory.createTimeLimitRace(length, route, prizePool, optionalParam[0]);
                break;
            case CIRCUIT_RACE_TYPE:
                race = RaceFactory.createCircuitRace(length, route, prizePool, optionalParam[0]);
                break;
        }
        this.races.putIfAbsent(id, race);
    }

    public void participate(int carId, int raceId) {
        if (this.cars.containsKey(carId) && this.races.containsKey(raceId) && !this.garage.getParkedCars().contains(this.cars.get(carId))) {
            Race race = this.races.get(raceId);
            if (race.getClass().getSimpleName().contains(TIME_LIMIT_RACE_TYPE) && race.getParticipants().size() == 1) {
                return;
            }
            Car car = this.cars.get(carId);
            race.addCar(car);
        }
    }

    public String start(int id) {
        if (this.races.containsKey(id) && this.races.get(id).getParticipants().size() != 0) {
            return this.races.remove(id).toString();
        }
        return "Cannot start the race with zero participants.";
    }

    public void park(int id) {
        if (this.cars.containsKey(id)) {
            Car car = this.cars.get(id);
            long countOfRaces = this.races.values().stream().filter(r -> r.getParticipants().contains(car)).count();
            if (countOfRaces == 0) {
                this.garage.park(car);
            }
        }
    }

    public void unpark(int id) {
        if (this.cars.containsKey(id) && this.garage.getParkedCars().contains(this.cars.get(id))) {
            Car car = this.cars.get(id);
            this.garage.unPark(car);
        }
    }

    public void tune(int tuneIndex, String addOn) {
        if (this.garage.getParkedCars().size() != 0) {
            this.garage.tune(tuneIndex, addOn);
        }
    }
}
