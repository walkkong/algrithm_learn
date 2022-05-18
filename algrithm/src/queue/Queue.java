package queue;

/**
 * @author liyanan
 * @date 2022/04/28 20:28
 **/
public interface Queue<E> {
    void enquque(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
