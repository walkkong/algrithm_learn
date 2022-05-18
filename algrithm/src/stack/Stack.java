package stack;

/**
 * @author liyanan
 * @date 2022/04/26 21:43
 **/
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
