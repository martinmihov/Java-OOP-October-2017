package cresla.core.commands;

import cresla.annotations.Inject;
import cresla.core.Executable;
import cresla.factories.ReactorFactory;
import cresla.interfaces.OutputWriter;
import cresla.interfaces.Reactor;
import cresla.repositories.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public class ReactorCommand implements Executable {
    @Inject
    private List<String> params;
    @Inject
    private OutputWriter writer;
    @Inject
    private Repository repository;

    @Override
    public void execute() throws IllegalAccessException {
        Reactor reactor = ReactorFactory.createReactor(this.params.get(1), Integer.parseInt(this.params.get(2)), Integer.parseInt(this.params.get(3)));
        this.repository.addReactor(reactor);
        this.repository.addIdentifiable(reactor);
        this.writer.writeLine(String.format("Created %s Reactor - %d", this.params.get(1), reactor.getId()));
    }
}
