package hell.core.commands;

import hell.annotations.Inject;
import hell.core.Executable;
import hell.interfaces.Hero;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public class InspectCommand implements Executable{
    @Inject
    private List<String> params;
    @Inject
    private Repository repository;
    @Inject
    private OutputWriter writer;

    @Override
    public void execute() {
        Hero hero = this.repository.getHeroByName(this.params.get(0));
        this.writer.writeLine(hero.toString());
    }
}
