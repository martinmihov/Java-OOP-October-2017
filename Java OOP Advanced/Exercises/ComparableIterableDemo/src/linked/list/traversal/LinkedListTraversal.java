package linked.list.traversal;

public interface LinkedListTraversal<E> extends Iterable<E> {
    void add(E element);

    boolean remove(E element);

    int getSize();
}
