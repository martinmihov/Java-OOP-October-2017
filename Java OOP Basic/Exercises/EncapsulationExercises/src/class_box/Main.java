package class_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        Class boxClass = Box.class;
//        Field[] fields = boxClass.getDeclaredFields();
//        System.out.println(Arrays.stream(fields)
//                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        Box box = new Box(Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()));

        System.out.println(box.getInfo());
    }
}
