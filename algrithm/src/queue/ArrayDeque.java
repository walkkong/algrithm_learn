package queue;

/**
 * @author liyanan
 * @date 2022/05/02 18:57
 **/
public class ArrayDeque<E> implements Deque<E>{
    private E[] data;
    private int front,tail;

    public ArrayDeque(int capacity) {
        data = (E[]) new Object[capacity];
        front = tail = 0;
    }

    public ArrayDeque() {
        this(16);
    }

    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 将元素从队头复制到队尾
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }
        // 重置 front 和 tail 的指向
        tail = getSize();
        front = 0;
        data = newData;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void addLast(E e) {
        if (isFull()) {
            // 扩容两倍
            resize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public void addFirst(E e) {
        if (isFull()) {
            resize(2 * getCapacity() + 1);
        }
        // 将元素插入 front 前面位置
        data[front = (front - 1 + data.length) % data.length] = e;
    }

    @Override
    public E removeLast() {
        E res = data[tail];
        data[tail] = null;
        tail = (tail - 1 + data.length) % data.length;
        return res;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("loopQueue: size = ");
        sb.append(getSize());
        sb.append(", capacity = ");
        sb.append(getCapacity());
        sb.append(", front [");
        for (int i = 0; i < getSize(); i++) {
            // 实际要访问的元素偏移了 front 的长度
            sb.append(data[(i + front) % data.length]);
            if (i < getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    @Override
    public int getSize() {
        return (tail - front + data.length) % data.length;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 28; i++) {
            deque.addFirst(i);
            System.out.println(deque);
            if (i % 3 == 2) {
                System.out.println("删除队尾元素");
                deque.removeLast();
                System.out.println(deque);
            }
        }
    }
}
