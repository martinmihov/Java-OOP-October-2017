package pokemon_trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private static final int DEFAULT_COUNT_OF_BADGES = 0;

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = DEFAULT_COUNT_OF_BADGES;
        this.pokemonList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public boolean hasElement(String element) {
        return this.pokemonList.stream().map(Pokemon::getElement).filter(p -> p.equals(element)).count() > 0;
    }

    public void addBadge() {
        this.numberOfBadges++;
    }

    public void allPokemonsReduceHealth() {
        this.pokemonList.forEach(Pokemon::reduceHealth);
        List<Pokemon> pokemonsToRemove = this.pokemonList.stream().filter(p -> p.getHealth() < 0).collect(Collectors.toList());
        this.pokemonList.removeAll(pokemonsToRemove);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemonList.size());
    }
}