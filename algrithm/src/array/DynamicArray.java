package array;

/**
 * @author liyanan
 * @date 2022/04/19 11:50
 **/
public class DynamicArray<E> {
    private E[] data;
    private int size;
    private static final int DEFAULT_SIZE = 16;

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }


    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Out of index!");
        }
    }

    private void checkSize() {
        if (size == data.length) {
            resize(data.length * 2);
        }
    }

    // O(n)
    public void addFirst(E e) {
        add(0, e);
    }

    // O(1)
    public void addLast(E e) {
        add(size, e);
    }

    // O(n)
    public void add(int index, E e) {
        checkSize();
        checkIndex(index);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("size = %d, capacity = %d, arr = [", size, data.length));
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public E remove(int index) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed. Array is empty");
        }
        checkIndex(index);
        E removeE = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        /*if (size == data.length / 2) {
            resize(data.length / 2);
        }*/

        // Lazy 更懒的时候性能反而会得到提升
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return removeE;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    // O(1)
    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
    }

    // O(1)
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    // O(n)
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    // O(n)
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // O(n)
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
