package mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String DEMON_TYPE = "Demon";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" \\| ");

        String username = tokens[0];
        String characterType = tokens[1];
        int level = Integer.parseInt(tokens[3]);

        GamePlayer gamePlayer = null;
        if (DEMON_TYPE.equals(characterType)) {
            double energy = Double.parseDouble(tokens[2]);
            gamePlayer = new Demon(username, level, energy);
        } else {
            int mana = Integer.parseInt(tokens[2]);
            gamePlayer = new Archangel(username, level, mana);
        }

        System.out.println(gamePlayer);
    }
}
