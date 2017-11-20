package hell.core.commands;

import hell.annotations.Inject;
import hell.core.Executable;
import hell.factories.ItemFactory;
import hell.interfaces.OutputWriter;
import hell.interfaces.Recipe;
import hell.repositories.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public class RecipeCommand implements Executable{
    private static final String CREATE_AND_ADD_RECIPE_TO_HERO_FORMAT = "Added recipe - %s to Hero - %s";

    @Inject
    private List<String> params;
    @Inject
    private Repository repository;
    @Inject
    private OutputWriter writer;

    @Override
    public void execute() {
        Recipe recipe = ItemFactory.makeRecipeItem(this.params.get(0), Integer.parseInt(this.params.get(2)), Integer.parseInt(this.params.get(3)), Integer.parseInt(this.params.get(4)), Integer.parseInt(this.params.get(5)), Integer.parseInt(this.params.get(6)), this.params.stream().skip(7).toArray(String[]::new));
        this.repository.getHeroByName(this.params.get(1)).addRecipe(recipe);
        this.writer.writeLine(CREATE_AND_ADD_RECIPE_TO_HERO_FORMAT, this.params.get(0), this.params.get(1));
    }
}
