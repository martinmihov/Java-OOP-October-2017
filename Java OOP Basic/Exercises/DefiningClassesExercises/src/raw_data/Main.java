package raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final String ENGINE_TYPE_FRAGILE = "fragile";
    private static final String ENGINE_TYPE_FLAMABLE = "flamable";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfCars = Integer.parseInt(reader.readLine());
        Map<String, List<String>> carModelsByEngineType = new LinkedHashMap<>();
        carModelsByEngineType.putIfAbsent(ENGINE_TYPE_FRAGILE, new ArrayList<>());
        carModelsByEngineType.putIfAbsent(ENGINE_TYPE_FLAMABLE, new ArrayList<>());

        while (countOfCars-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Engine engine = new Engine(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            Cargo cargo = new Cargo(Double.parseDouble(tokens[3]), tokens[4]);

            String[] tiresTokens = Arrays.stream(tokens).skip(5).toArray(String[]::new);
            List<Tire> tires = new ArrayList<>();

            for (int i = 0; i < tiresTokens.length; i += 2) {
                Tire tire = new Tire(Double.parseDouble(tiresTokens[i]), Integer.parseInt(tiresTokens[i + 1]));
                tires.add(tire);
            }

            Car car = new Car(tokens[0], engine, cargo, tires);

            if (car.getCargo().getType().equals(ENGINE_TYPE_FLAMABLE) && car.getEngine().getPower() > 250) {
                carModelsByEngineType.get(ENGINE_TYPE_FLAMABLE).add(car.getModel());
            } else if (car.getCargo().getType().equals(ENGINE_TYPE_FRAGILE) && car.getTires().stream().filter(t -> t.getPressure() < 1).count() > 0) {
                carModelsByEngineType.get(ENGINE_TYPE_FRAGILE).add(car.getModel());
            }
        }

        String keyWord = reader.readLine();

        if (ENGINE_TYPE_FRAGILE.equals(keyWord)) {
            printCarModels(carModelsByEngineType, ENGINE_TYPE_FRAGILE);
        } else if (ENGINE_TYPE_FLAMABLE.equals(keyWord)) {
            printCarModels(carModelsByEngineType, ENGINE_TYPE_FLAMABLE);
        }
    }

    private static void printCarModels(Map<String, List<String>> carModelsByEngineType, String engineType) {
        carModelsByEngineType.entrySet()
                .stream()
                .filter(c -> c.getKey().equals(engineType))
                .forEach(c -> c.getValue()
                        .forEach(System.out::println));
    }
}
