package collection_hierarchy;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddRemoveCollectionImpl<T> implements AddRemoveCollection<T> {

    private Deque<T> elements;

    public AddRemoveCollectionImpl() {
        this.elements = new ArrayDeque();
    }

    @Override
    public int addFirst(T element) {
        this.elements.addFirst(element);
        return 0;
    }

    @Override
    public T remove() {
        return this.elements.removeLast();
    }
}
