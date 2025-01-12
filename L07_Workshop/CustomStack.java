package L07_Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {

    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int size;
    private int[] items;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[INITIAL_CAPACITY];
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            this.resize(this.capacity * 2);
        }
        this.items[this.size++] = element;
    }

    public int peek() {
        checkEmpty();
        if (this.size > 0) {
            return this.items[this.size - 1];
        }
        return 0;
    }

    public void forEach(Consumer<Integer> intConsumer) {
        for (int i = 0; i < this.size; i++) {
            intConsumer.accept(this.items[i]);
        }
    }

    public int pop() {
        checkEmpty();
        int element = this.items[this.size - 1];
        this.size--;
        return element;
    }



    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty");
        }
    }

    private void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < this.items.length; i++) {
            temp[i] = items[i];
        }
        this.items = temp;
        this.capacity = capacity;
    }
}
