package football_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        String line;

        while (true) {
            if ("END".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(";");

            try {
                switch (tokens[0]) {
                    case "Team":
                        createTeam(teams, tokens[1]);
                        break;
                    case "Add":
                        addPlayer(teams, tokens);
                        break;
                    case "Remove":
                        removePlayer(teams, tokens);
                        break;
                    case "Rating":
                        printRating(teams, tokens[1]);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }

    }

    private static void removePlayer(Map<String, Team> teams, String[] tokens) {
        teams.get(tokens[1]).removePlayer(tokens[2]);
    }

    private static void printRating(Map<String, Team> teams, String token) {
        if (teams.containsKey(token)) {
            System.out.println(String.format("%s - %.0f", token, teams.get(token).getRating()));
        } else {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", token));
        }
    }

    private static void addPlayer(Map<String, Team> teams, String[] tokens) {
        if (teams.containsKey(tokens[1])) {
            teams.get(tokens[1]).addPlayer(new Player(tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7])));
        } else {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", tokens[1]));
        }
    }

    private static void createTeam(Map<String, Team> teams, String token) {
        Team team = new Team(token);
        teams.putIfAbsent(team.getName(), team);
    }
}
