package mankind;

public abstract class Human {
    private static final String EXPECTED_UPPER_CASE_LETTER_ERROR_MESSAGE = "Expected upper case letter!Argument: %s";
    private static final String EXPECTED_LENGTH_FIRST_NAME_ERROR_MESSAGE = "Expected length at least 4 symbols!Argument: %s";
    public static final String EXPECTED_LENGTH_LAST_NAME_ERROR_MESSAGE = "Expected length at least 3 symbols!Argument: %s";

    private String firstName;
    private String lastName;

    protected Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(String.format(EXPECTED_UPPER_CASE_LETTER_ERROR_MESSAGE, "firstName"));
        }
        if (firstName.length() < 4) {
            throw new IllegalArgumentException(String.format(EXPECTED_LENGTH_FIRST_NAME_ERROR_MESSAGE, "firstName"));
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException(String.format(EXPECTED_UPPER_CASE_LETTER_ERROR_MESSAGE, "lastName"));
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(String.format(EXPECTED_LENGTH_LAST_NAME_ERROR_MESSAGE, "lastName"));
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s", this.firstName)).append(System.lineSeparator())
                .append(String.format("Last Name: %s", this.lastName)).append(System.lineSeparator());
        return sb.toString();
    }
}