package stack;

/**
 * @author liyanan
 * @date 2022/04/26 21:44
 **/
public class ArrayStack<E> implements Stack<E> {
    private DynamicArray<E> array;
    private static final int DEFAULT_SIZE = 16;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                '}' + " top";
    }
}
