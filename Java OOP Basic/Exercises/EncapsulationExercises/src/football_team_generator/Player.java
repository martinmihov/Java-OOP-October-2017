package football_team_generator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    public double getOverallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }

    private void setName(String name) {
        if (name == null || name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validate("Endurance", endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validate("Sprint", sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validate("Dribble", dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validate("Passing", passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validate("Shooting", shooting);
        this.shooting = shooting;
    }


    private void validate(String statName, int stat) {
        String debug = "";
        if (isNotValid(stat)) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }

    private boolean isNotValid(int stat) {
        return stat < 0 || stat > 100;
    }
}