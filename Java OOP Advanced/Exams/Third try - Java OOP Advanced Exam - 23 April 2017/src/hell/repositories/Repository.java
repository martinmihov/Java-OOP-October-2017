package hell.repositories;

import hell.interfaces.Hero;

import java.util.Map;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public interface Repository {
    void addHero(Hero hero);

    Hero getHeroByName(String heroName);

    Map<String, Hero> getHeroes();
}
