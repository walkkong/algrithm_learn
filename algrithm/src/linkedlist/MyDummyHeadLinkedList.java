package linkedlist;

/**
 * @author liyanan
 * @date 2022/05/05 10:54
 **/
public class MyDummyHeadLinkedList<E> {
    /**节点*/
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**虚拟头节点*/
    private Node dummyHead;
    /*链表长度*/
    private int size;

    public MyDummyHeadLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = dummyHead.next;
        int i = 0;
        while (temp != null) {
            sb.append(temp.e);
            temp = temp.next;
            if (i <= size - 1) {
                sb.append("->");
            }
            i++;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyDummyHeadLinkedList<Integer> myLinkedList = new MyDummyHeadLinkedList<>();
        for (int i = 0; i < 16; i++) {
            myLinkedList.addLast(i);
            System.out.println(myLinkedList);
        }
        myLinkedList.add(3, 50);
        System.out.println(myLinkedList);
        myLinkedList.set(5, 100);
        System.out.println(myLinkedList);
    }
}
