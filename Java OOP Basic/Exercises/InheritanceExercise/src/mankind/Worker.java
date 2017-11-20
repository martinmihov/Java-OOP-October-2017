package mankind;

public class Worker extends Human {
    private static final String VALUE_MISMATCH_ERROR_MESSAGE = "Expected value mismatch!Argument: %s";

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(String.format(Human.EXPECTED_LENGTH_LAST_NAME_ERROR_MESSAGE, "lastName"));
        }
        super.setLastName(lastName);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException(String.format(VALUE_MISMATCH_ERROR_MESSAGE, "weekSalary"));
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException(String.format(VALUE_MISMATCH_ERROR_MESSAGE, "workHoursPerDay"));
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getEarnMoneyByHour() {
        return this.weekSalary / (this.workHoursPerDay * 7);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(String.format("Week Salary: %.2f", this.weekSalary)).append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.workHoursPerDay)).append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.getEarnMoneyByHour()));
        return sb.toString();
    }
}
