package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] tokens = Arrays.stream(reader.readLine().split("[\\s,]+")).map(Integer::valueOf).toArray(Integer[]::new);

        Lake<Integer> lake = new Lake<>(tokens);

        List<String> result = new ArrayList<>();
        for (Integer integer : lake) {
            result.add(String.valueOf(integer));
        }

        System.out.println(String.join(", ", result));
    }
}
