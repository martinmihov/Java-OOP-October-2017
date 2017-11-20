package hell.core.commands;

import hell.annotations.Inject;
import hell.core.Executable;
import hell.factories.HeroFactory;
import hell.interfaces.Hero;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public class HeroCommand implements Executable{
    private static final String CREATE_HERO_FORMAT = "Created %s - %s";

    @Inject
    private List<String> params;
    @Inject
    private Repository repository;
    @Inject
    private OutputWriter writer;

    @Override
    public void execute() {
        Hero hero = HeroFactory.makeHero(this.params.get(0), this.params.get(1));
        this.repository.addHero(hero);
        this.writer.writeLine(CREATE_HERO_FORMAT, this.params.get(1), this.params.get(0));
    }
}
