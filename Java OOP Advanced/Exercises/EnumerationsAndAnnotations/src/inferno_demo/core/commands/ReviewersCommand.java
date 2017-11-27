package inferno_demo.core.commands;

import inferno_demo.annotations.CustomAnnotation;
import inferno_demo.core.BaseCommand;
import inferno_demo.models.impl.Weapon;

public class ReviewersCommand extends BaseCommand {
    @Override
    public String execute() {
        CustomAnnotation annotation = Weapon.class.getAnnotation(CustomAnnotation.class);
        return String.format("Reviewers: %s", String.join(", ", annotation.reviewers()));
    }
}
