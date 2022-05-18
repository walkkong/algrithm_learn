package queue;

/**
 * @author liyanan
 * @date 2022/04/28 20:29
 **/
public class ArrayQueue<E> implements Queue<E> {
    private DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        this(16);
    }

    @Override
    public void enquque(E e) {
        // 入队：在数组末尾添加元素
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        // O(n)
        // 出队：删除数组第一个元素
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        // 获得队首，拿到数组第一个元素
        return array.getFirst();
    }

    @Override
    public int getSize() {
        // 获得数组 size
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array= " + array +
                '}' + " tail";
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enquque(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(i);
            }
        }
    }
}
