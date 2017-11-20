package mordors_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> foods = Arrays.asList(reader.readLine().split("\\s+"));

        Wizard wizard = new Wizard();

        wizard.setHappinessIndex(foods);
        System.out.println(wizard.getHappinessIndex());
        System.out.println(wizard.getMood());
    }
}
