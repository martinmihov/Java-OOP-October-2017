package telephony;

public class Smartphone implements Callable, Browsable {

    @Override
    public String browsing(String url) {
        if (url.matches(".*\\d+.*")) {
            return "Invalid URL!";
        }
        return String.format("Browsing: %s!", url);
    }

    @Override
    public String calling(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            return "Invalid number!";
        }
        return String.format("Calling... %s", phoneNumber);
    }
}
