package queue;

/**
 * @author liyanan
 * @date 2022/05/02 16:10
 **/
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front;
    private int tail;

    public LoopQueue() {
        this(16);
    }

    public LoopQueue(int capacity) {
        // capacity + 1：使用时会浪费一个空间
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    @Override
    public void enquque(E e) {
        if (isFull()) {
            // 扩容两倍
            resize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
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
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return (tail - front + data.length) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
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

    public void resize(int newCapacity) {
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

    public int getCapacity() {
        return data.length - 1;
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 17; i++) {
            loopQueue.enquque(i);
            System.out.println(loopQueue);
            if (i % 3 == 2) {
                System.out.println("开始出队");
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}
