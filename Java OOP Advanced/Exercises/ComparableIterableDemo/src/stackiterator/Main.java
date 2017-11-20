package stackiterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();

        StackIterator<Integer> stackIterator = new StackIterator<>();

        while (!"END".equals(line)) {

            if(line.contains("Pop")) {
                try {
                    stackIterator.pop();
                } catch (IndexOutOfBoundsException ioob) {
                    System.out.println(ioob.getMessage());
                }
            } else {
                List<String> lineArgs = Arrays.asList(line.split("[,\\s]"));

                for (int i = 1; i < lineArgs.size(); i++) {
                    if(lineArgs.get(i).matches("\\d+")) {
                        stackIterator.push(Integer.parseInt(lineArgs.get(i)));
                    }
                }
            }

            line = bufferedReader.readLine();
        }

        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
    }
}
