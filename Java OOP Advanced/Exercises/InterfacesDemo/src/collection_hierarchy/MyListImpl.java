package collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyListImpl<T> implements MyList<T> {

    private List<T> elements;

    public MyListImpl() {
        this.elements = new ArrayList<>();
    }

    public int add(T element) {
        this.elements.add(0, element);
        return this.elements.indexOf(element);
    }

    public T remove() {
        return this.elements.remove(0);
    }

    public int size() {
        return this.elements.size();
    }
}
