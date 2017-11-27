package inferno_demo.core.commands;

import inferno_demo.annotations.CustomAnnotation;
import inferno_demo.core.BaseCommand;
import inferno_demo.models.impl.Weapon;

public class RevisionCommand extends BaseCommand {
    @Override
    public String execute() {
        CustomAnnotation annotation = Weapon.class.getAnnotation(CustomAnnotation.class);
        return String.format("Revision: %s", annotation.revision());
    }
}
