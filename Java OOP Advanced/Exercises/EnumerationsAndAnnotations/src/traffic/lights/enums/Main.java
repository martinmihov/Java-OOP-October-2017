package traffic.lights.enums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] stringLights = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < stringLights.length; j++) {
                stringLights[j] = TrafficLight.valueOf(stringLights[j]).next().name();
                sb.append(TrafficLight.valueOf(stringLights[j])).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
