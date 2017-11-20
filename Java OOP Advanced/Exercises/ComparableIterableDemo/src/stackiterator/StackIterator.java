package stackiterator;

import java.util.*;

public class StackIterator<T> implements Iterable<T> {

    private int initialSize;
    private T[] deque;
    private int currentElementPosition;

    public StackIterator() {
        this.initialSize = 8;
        this.deque = (T[]) new Object[this.initialSize];
        this.currentElementPosition = 0;
    }


    public void push(T item) {
        if (this.currentElementPosition == this.deque.length) {
            this.expandSize();
        }
        this.deque[this.currentElementPosition++] = item;
    }

    public T pop() {
        // retrieve top most element
        if(this.currentElementPosition - 1 < 0) {
            throw new IndexOutOfBoundsException("No elements");
        }
        T t = this.deque[--this.currentElementPosition];
        // empty its position
        this.deque[this.currentElementPosition] = null;
        return t;
    }

    public int size() {
        return currentElementPosition;
    }

    private void expandSize() {
        int increasedSize = this.deque.length * 2;
        // create a new array with double size and copy existing contents into it
        this.deque = Arrays.copyOf(this.deque, increasedSize);
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorInStackIterator();
    }

    private final class IteratorInStackIterator implements Iterator<T> {

        private int index;

        public IteratorInStackIterator() {
            this.index = size();
        }

        @Override
        public boolean hasNext() {
            return this.index > 0;
        }

        @Override
        public T next() {
            return deque[--index];
        }
    }
}
