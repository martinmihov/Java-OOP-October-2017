package listy_iterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private static final String COLLECTION_WITHOUT_ELEMENTS_EXXCEPTION_MESSAGE = "Invalid Operation!";

    private int index;

    private List<String> collection;

    public ListyIterator(String... collection) {
        this.collection = Arrays.asList(collection);
        this.index = 0;
    }

    public boolean move() {
        if (this.collection.size() - 1 == this.index) {
            return false;
        }
        this.index++;
        return true;
    }

    public boolean hasNext() {
        return this.collection.size() - 1 != this.index;
    }

    public void print() {
        if (this.collection.size() == 0) {
            throw new CollectionWithoutElementsException(COLLECTION_WITHOUT_ELEMENTS_EXXCEPTION_MESSAGE);
        }
        System.out.println(this.collection.get(this.index));
    }
}
