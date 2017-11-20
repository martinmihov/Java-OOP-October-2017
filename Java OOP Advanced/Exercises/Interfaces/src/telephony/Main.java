package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numberPhones = reader.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone();

        Arrays.stream(numberPhones).forEach(pn -> System.out.println(smartphone.calling(pn)));

        String[] urls = reader.readLine().split("\\s+");

        Arrays.stream(urls).forEach(url -> System.out.println(smartphone.browsing(url)));
    }
}
