package Mankindd;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, Team> teams = new HashMap<>();

        while (!input.equals("END")) {

            String[] inputArgs = input.split(";");
            String currentCommand = inputArgs[0];

            switch (currentCommand) {
                case "Team":
                    try {
                        Team team = new Team(inputArgs[1]);
                        teams.putIfAbsent(inputArgs[1], team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (teams.containsKey(inputArgs[1])) {
                        System.out.println(String.format("%s - %.0f", inputArgs[1], teams.get(inputArgs[1]).calculateRating()));
                    } else {
                        System.out.println("Team " + inputArgs[1] + " does not exist.");
                    }
                    break;
                case "Remove":
                    if (teams.containsKey(inputArgs[1])) {
                        try {
                            teams.get(inputArgs[1]).removePlayer(inputArgs[2]);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Team " + inputArgs[1] + " does not exist.");
                    }
                    break;
                case "Add":
                    try {
                        if (teams.containsKey(inputArgs[1])) {
                            int endurance = Integer.valueOf(inputArgs[3]);
                            int sprint = Integer.valueOf(inputArgs[4]);
                            int dribble = Integer.valueOf(inputArgs[5]);
                            int passing = Integer.valueOf(inputArgs[6]);
                            int shooting = Integer.valueOf(inputArgs[7]);
                            Player player = new Player(inputArgs[2], endurance, sprint, dribble, passing, shooting);

                            teams.get(inputArgs[1]).addPlayer(player);
                        } else {
                            System.out.println("Team " + inputArgs[1] + " does not exist.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            input = scanner.nextLine();
        }

    }
}