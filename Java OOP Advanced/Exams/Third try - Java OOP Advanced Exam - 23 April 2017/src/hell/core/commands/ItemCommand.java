package hell.core.commands;

import hell.annotations.Inject;
import hell.core.Executable;
import hell.factories.ItemFactory;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public class ItemCommand implements Executable{
    private static final String CREATE_AND_ADD_ITEM_TO_HERO_FORMAT = "Added item - %s to Hero - %s";

    @Inject
    private List<String> params;
    @Inject
    private Repository repository;
    @Inject
    private OutputWriter writer;

    @Override
    public void execute() {
        Item item = ItemFactory.makeCommonItem(this.params.get(0), Integer.parseInt(this.params.get(2)), Integer.parseInt(this.params.get(3)), Integer.parseInt(this.params.get(4)), Integer.parseInt(this.params.get(5)), Integer.parseInt(this.params.get(6)));
        this.repository.getHeroByName(this.params.get(1)).addItem(item);
        this.writer.writeLine(CREATE_AND_ADD_ITEM_TO_HERO_FORMAT, this.params.get(0), this.params.get(1));
    }
}
