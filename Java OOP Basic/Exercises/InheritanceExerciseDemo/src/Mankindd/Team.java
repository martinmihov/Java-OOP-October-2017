package Mankindd;

import java.util.HashMap;
import java.util.OptionalDouble;
 
public class Team {
    private String name;
    private HashMap<String, Player> players;
 
    public Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
    }
 
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
 
    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }
 
    public void removePlayer(String player) {
        if (players.containsKey(player)) {
            players.remove(player);
        } else {
            throw new IllegalArgumentException("Player " + player + " is not in " + this.name + " team.");
        }
    }
 
    public double calculateRating() {
        OptionalDouble average = this.players.entrySet().stream().mapToDouble(x -> x.getValue().getAverage()).average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            return 0;
        }
    }
 
}