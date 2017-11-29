package pr0304Barracks.core.commands;

public class ReportCommand extends Command {

    @Override
    public String execute() {
        String output = super.getRepository().getStatistics();
        return output;
    }
}
