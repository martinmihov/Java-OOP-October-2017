package solutions.pr05SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Car {

    String model;
    double fuelAmmount;
    double fuelCostForPerKm;
    int distanceTraveled;

    public Car(String model, double fuelAmmount, double fuelCost) {
        this.model = model;
        this.fuelAmmount = fuelAmmount;
        this.fuelCostForPerKm = fuelCost;
        this.distanceTraveled = 0;
    }

    public void drive(int kilometers) {
        double neededFuel = fuelCostForPerKm * kilometers;
        if (neededFuel > this.fuelAmmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuelAmmount -= neededFuel;
            this.distanceTraveled += kilometers;
        }
    }

}

public class Pr05SpeedRacing {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] parameters = reader.readLine().split("\\s+");
            String model = parameters[0];
            double fuelAmmount = Double.parseDouble(parameters[1]);
            double fuelCost = Double.parseDouble(parameters[2]);
            cars.add(new Car(model, fuelAmmount, fuelCost));
        }

        String line = reader.readLine();
        while (!line.equals("End")) {
            String[] parameters = line.split("\\s+");
            String model = parameters[1];
            int kilometers = Integer.parseInt(parameters[2]);
            Car firstCar = null;
            for (Car car : cars) {
                if (car.model.equals(model)) {
                    firstCar = car;
                    break;
                }
            }
            firstCar.drive(kilometers);
            line = reader.readLine();
        }

        for (Car car : cars) {
            System.out.printf("%s %.2f %d%n", car.model, car.fuelAmmount, car.distanceTraveled);
        }
    }
}
