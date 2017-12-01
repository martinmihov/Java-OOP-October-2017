package cresla.core.commands;

import cresla.annotations.Inject;
import cresla.core.Executable;
import cresla.interfaces.OutputWriter;
import cresla.repositories.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 12/05/2017.
 */
public class ReportCommand implements Executable {
    @Inject
    private List<String> params;
    @Inject
    private OutputWriter writer;
    @Inject
    private Repository repository;

    @Override
    public void execute() throws IllegalAccessException {
        this.writer.writeLine(this.repository.getIdentifiableById(Integer.parseInt(this.params.get(1))).toString());
    }
}
