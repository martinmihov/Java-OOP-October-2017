package hell.core.commands;

import hell.annotations.Inject;
import hell.core.Executable;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public class QuitCommand implements Executable{

    @Inject
    private List<String> params;
    @Inject
    private Repository repository;
    @Inject
    private OutputWriter writer;

    @Override
    public void execute() throws IllegalAccessException {
        Map<String, Hero> sortedHeroes = this.repository.getHeroes().entrySet()
                .stream()
                .sorted((a,b) -> {
                    long firstHero = a.getValue().getStrength() + a.getValue().getAgility() + a.getValue().getIntelligence();
                    long secondHero = b.getValue().getStrength() + b.getValue().getAgility() + b.getValue().getIntelligence();
                    long firstComp = secondHero - firstHero;
                    if (firstComp != 0) {
                        return Long.compare(secondHero, firstHero);
                    }
                    firstHero = a.getValue().getHitPoints() + a.getValue().getDamage();
                    secondHero = b.getValue().getHitPoints() + b.getValue().getDamage();
                    return Long.compare(secondHero, firstHero);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int counter = 0;
        for (Hero hero : sortedHeroes.values()) {
            String sb = String.format("%d. %s: %s%s", ++counter, hero.getClass().getSimpleName(), hero.getName(), System.lineSeparator()) +
                    String.format("###HitPoints: %d%s", hero.getHitPoints(), System.lineSeparator()) +
                    String.format("###Damage: %d%s", hero.getDamage(), System.lineSeparator()) +
                    String.format("###Strength: %d%s", hero.getStrength(), System.lineSeparator()) +
                    String.format("###Agility: %d%s", hero.getAgility(), System.lineSeparator()) +
                    String.format("###Intelligence: %d%s", hero.getIntelligence(), System.lineSeparator()) +
                    String.format("###Items: %s", hero.getItems().size() == 0 ? "None" : String.join(", ", hero.getItems().stream().map(Item::getName).collect(Collectors.toList())));
            this.writer.writeLine(sb);
        }
    }
}
