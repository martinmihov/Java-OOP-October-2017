package linked.list.traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        LinkedListTraversal<Integer> listTraversal = new LinkedListTraversalImpl<>();

        for (int i = 0; i < n; i++) {
            String[] lineArgs = bufferedReader.readLine().split("\\s+");

            switch (lineArgs[0]) {
                case "Add":
                    listTraversal.add(Integer.parseInt(lineArgs[1]));
                    break;
                case "Remove":
                    listTraversal.remove(Integer.parseInt(lineArgs[1]));
                    break;
            }
        }

        System.out.println(listTraversal.getSize());
        listTraversal.forEach(element -> System.out.print(element + " "));
    }
}
