package car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfEngines = Integer.parseInt(reader.readLine());
        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        while (countOfEngines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            if (tokens.length < 2 || tokens.length > 4) {
                continue;
            }

            Engine engine = null;
            switch (tokens.length) {
                case 2:
                    engine = new Engine(tokens[0], Double.parseDouble(tokens[1]));
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        engine = new Engine(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]));
                    } else {
                        engine = new Engine(tokens[0], Double.parseDouble(tokens[1]), tokens[2]);
                    }
                    break;
                case 4:
                    engine = new Engine(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
            }

            if (engine != null) {
                engines.putIfAbsent(engine.getModel(), engine);
            }
        }

        int countOfCars = Integer.parseInt(reader.readLine());

        while (countOfCars-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            if (tokens.length < 2 || tokens.length > 4) {
                continue;
            }

            Car car = null;
            switch (tokens.length) {
                case 2:
                    car = new Car(tokens[0], engines.get(tokens[1]));
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        car = new Car(tokens[0], engines.get(tokens[1]), Integer.parseInt(tokens[2]));
                    } else {
                        car = new Car(tokens[0], engines.get(tokens[1]), tokens[2]);
                    }
                    break;
                case 4:
                    car = new Car(tokens[0], engines.get(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
            }

            if (car != null) {
                cars.add(car);
            }
        }

        cars.forEach(System.out::println);
    }
}
