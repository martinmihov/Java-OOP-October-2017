package froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake<T extends Integer> implements Iterable<T> {

    private List<T> numbers;

    public Lake(T... numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {

        private List<T> indexes;
        private int index;

        public Frog() {
            this.index = 0;
            this.setIndexes();
        }

        @Override
        public boolean hasNext() {
            return this.index < this.indexes.size();
        }

        @Override
        public T next() {
            return this.indexes.get(this.index++);
        }

        private void setIndexes() {
            this.indexes = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 == 0) {
                    this.indexes.add(numbers.get(i));
                }
            }

            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 != 0) {
                    this.indexes.add(numbers.get(i));
                }
            }
            String debug = "";
        }
    }
}
