package speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();

        int countOfCars = Integer.parseInt(bufferedReader.readLine());

        while (countOfCars-- > 0) {
            String[] tokens = bufferedReader.readLine().split("\\s+");

            if (!cars.containsKey(tokens[0])) {
                Car car = new Car(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                cars.putIfAbsent(car.getModel(), car);
            }
        }

        String line;
        while (true) {
            if ("end".equalsIgnoreCase(line = bufferedReader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            if (cars.containsKey(tokens[1])) {
                cars.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            }
        }

        cars.values().forEach(System.out::println);
    }
}
