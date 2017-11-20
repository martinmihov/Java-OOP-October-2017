package collection_hierarchy;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyListImpl<T> implements MyList<T> {

    private Deque<T> elements;

    public MyListImpl() {
        this.elements = new ArrayDeque<>();
    }

    @Override
    public int addFirst(T element) {
        this.elements.addFirst(element);
        return 0;
    }

    @Override
    public T removeFirst() {
        return this.elements.removeFirst();
    }

    @Override
    public int size() {
        return this.elements.size();
    }
}
