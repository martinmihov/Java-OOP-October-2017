package vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Vehicle> vehicles = new HashMap<>();

        String[] carTokens = reader.readLine().split("\\s+");
        String[] truckTokens = reader.readLine().split("\\s+");
        String[] busTokens = reader.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Double.parseDouble(carTokens[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Double.parseDouble(truckTokens[3]));
        Vehicle bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));

        vehicles.putIfAbsent("Car", car);
        vehicles.putIfAbsent("Truck", truck);
        vehicles.putIfAbsent("Bus", bus);

        int countOfCommands = Integer.parseInt(reader.readLine());

        while (countOfCommands-- > 0) {
            String[] commandTokens = reader.readLine().split("\\s+");
            try {
                String pattern = "#.##";
                DecimalFormat decimalFormat = new DecimalFormat(pattern);

                String vehicleType = commandTokens[1];
                switch (commandTokens[0]) {
                    case "Drive":
                        Double distance = Double.parseDouble(commandTokens[2]);
                        vehicles.get(vehicleType).drive(distance);
                        System.out.println(String.format("%s travelled %s km", vehicleType, decimalFormat.format(distance)));
                        break;
                    case "Refuel":
                        vehicles.get(vehicleType).refuel(Double.parseDouble(commandTokens[2]));
                        break;
                    case "DriveEmpty":
                        Double distanceBus = Double.parseDouble(commandTokens[2]);
                        vehicles.get(vehicleType).driveEmpty(distanceBus);
                        System.out.println(String.format("%s travelled %s km", vehicleType, decimalFormat.format(distanceBus)));
                        break;
                }
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}