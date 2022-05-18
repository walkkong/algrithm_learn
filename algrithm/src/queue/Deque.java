package queue;

/**
 * @author liyanan
 * @date 2022/05/02 18:56
 **/
public interface Deque<E> {
    boolean isEmpty();
    void addLast(E e);
    void addFirst(E e);
    E removeLast();
    E removeFirst();
    int getSize();
}
