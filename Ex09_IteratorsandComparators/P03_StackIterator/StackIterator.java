package Ex09_IteratorsandComparators.P03_StackIterator;

import java.util.Iterator;

public class StackIterator implements Iterable<Integer>{
    private Integer[] elements;
    private int internalIndex;

    public StackIterator() {
        this.elements = new Integer[16];
        this.internalIndex = 0;
    }

    public void push(int element) {
        this.elements[this.internalIndex++] = element;
    }

    public Integer pop() {
        if (this.internalIndex == 0) {
            throw new IllegalStateException("No elements");
        }
        Integer element = this.elements[this.internalIndex - 1];
        this.elements[this.internalIndex - 1] = null;
        this.internalIndex--;
        return element;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = internalIndex - 1;
            @Override
            public boolean hasNext() {
                return this.index >= 0;
            }

            @Override
            public Integer next() {
                return elements[this.index--];
            }
        };
    }
}
