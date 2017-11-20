package mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" \\| ");

        GameObject gameObject = null;
        switch (tokens[1]) {
            case "Demon":
                gameObject = new Demon(tokens[0], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[2]));
                break;
            case "Archangel":
                gameObject = new Archangel(tokens[0], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[2]));
                break;
        }

        System.out.println(gameObject);
    }
}
