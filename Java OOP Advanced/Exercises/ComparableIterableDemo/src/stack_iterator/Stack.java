package stack_iterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Stack<Integer> implements Iterable<Integer> {
    private static final int INITIAL_CAPACITY = 10;

    private Integer[] stack;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.stack = (Integer[]) Array.newInstance(java.lang.Integer.class, INITIAL_CAPACITY);
        ;
    }

    public Integer pop() {
        int len = this.stack.length;
        Integer num = this.stack[this.stack.length - 1];
//        removeElementAt(len - 1);
//        return obj;
        return this.stack[0];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private void growSizeOfStack() {
        this.stack = Arrays.copyOf(this.stack, this.stack.length * 2);
    }

    private void trimSizeOfStack() {
        this.stack = Arrays.copyOf(this.stack, this.stack.length / 2);
    }

    private final class StackIterator implements Iterator<Integer> {

        private int index;

        public StackIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < stack.length;
        }

        @Override
        public Integer next() {
            if (this.index + 1 == stack.length) {
                growSizeOfStack();
            }
            if (this.index + 1 <= stack.length / 4) {
                trimSizeOfStack();
            }
            return stack[this.index++];
        }
    }
}
