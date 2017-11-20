package football_team_generator;

import java.util.HashMap;
import java.util.Map;

public class Team {
    private Map<String, Player> players;
    private String name;
    private double rating;

    public Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {
        return this.players.values().stream().mapToDouble(Player::getOverallSkillLevel).sum();
    }

    public void addPlayer(Player player) {
        this.players.putIfAbsent(player.getName(), player);
    }

    public void removePlayer(String playerName) {
        if (!this.players.containsKey(playerName)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }
        this.players.remove(playerName);
    }
}