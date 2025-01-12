package L07_Workshop;

import java.util.function.Consumer;

public class SmartArray {

    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public int size() {
        return this.size;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            this.resize(this.capacity * 2);
        }
        this.data[this.size++] = element;
    }

    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    public int remove(int index) {
        checkIndex(index);
        int element = this.data[index];
        int[] temp = new int[this.capacity];

        System.arraycopy(this.data, 0, temp, 0, index);
        System.arraycopy(this.data, index + 1, temp, index, this.size - index);

        this.data = temp;
        this.size--;
        if (this.size == this.capacity / 2) {
            this.shrink();
        }
        return element;
    }

    public boolean contains(int element) {
        for (int num : this.data) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        checkIndex(index);
        if (this.size + 1 == this.capacity) {
            this.resize(this.capacity * 2);
        }
        int[] temp = new int[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, index);
        temp[index] = element;
        System.arraycopy(this.data, index, temp, index + 1, this.size - index);
        this.data = temp;
        this.size++;
    }

    public void forEach(Consumer<Integer> intConsumer) {
        for (int i = 0; i < this.size; i++) {
            intConsumer.accept(this.data[i]);
        }
    }

    private void shrink() {
        this.resize(this.capacity);
    }

    private void checkIndex(int index) {
        if (index > 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, this.size));
        }
    }

    private void resize(int newCapacity) {
        int[] temp = new int[newCapacity];
        for (int i = 0; i < this.size; i++) {
            temp[i] = data[i];
        }
        this.data = temp;
        this.capacity = newCapacity;
    }
}
