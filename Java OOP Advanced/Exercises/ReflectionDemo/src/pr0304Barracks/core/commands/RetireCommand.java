package pr0304Barracks.core.commands;

public class RetireCommand extends Command {
    private static final String RETIRE_MESSAGE_FORMAT = "%s retired!";

    @Override
    public String execute() {
        try {
            super.getRepository().removeUnit(super.getData()[1]);
        } catch (IllegalStateException ise) {
            return ise.getMessage();
        }
        return String.format(RETIRE_MESSAGE_FORMAT, super.getData()[1]);
    }
}
