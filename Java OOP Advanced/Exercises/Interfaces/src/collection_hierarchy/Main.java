package collection_hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection<String> addCollection = new AddCollectionImpl<>();
        AddRemoveCollection<String> addRemoveCollection = new AddRemoveCollectionImpl<>();
        MyList<String> myList = new MyListImpl<>();

        String[] tokens = reader.readLine().split(" ");
        int count = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>();

        for (String token : tokens) {
            list.add(addCollection.add(token));
        }
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));

        list.clear();
        for (String token : tokens) {
            list.add(addRemoveCollection.addFirst(token));
        }
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));

        list.clear();
        for (String token : tokens) {
            list.add(myList.addFirst(token));
        }
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list1.add(addRemoveCollection.remove());
        }
        System.out.println(list1.stream().map(String::valueOf).collect(Collectors.joining(" ")));

        list1.clear();
        for (int i = 0; i < count; i++) {
            list1.add(myList.removeFirst());
        }
        System.out.println(list1.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
