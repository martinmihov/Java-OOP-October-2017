package avatar.factories;

import avatar.entities.cars.Car;
import avatar.entities.cars.PerformanceCar;
import avatar.entities.cars.ShowCar;

public final class CarFactory {

    private CarFactory() {}

    public static Car createShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public static Car createPerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }
}
