package mankind;

public class Worker extends Human {

    private double weekSalary;
    private double hoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setHoursPerDay(double hoursPerDay) {
        if (hoursPerDay < 1 || hoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.hoursPerDay = hoursPerDay;
    }

    private double calculateSalaryPerHour() {
        return this.weekSalary / (this.hoursPerDay * 7);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Week Salary: %.2f", this.weekSalary)).append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.hoursPerDay)).append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.calculateSalaryPerHour())).append(System.lineSeparator());
        return super.toString() + sb.toString();
    }
}