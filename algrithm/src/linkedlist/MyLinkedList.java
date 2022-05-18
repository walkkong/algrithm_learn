package linkedlist;

/**
 * @author liyanan
 * @date 2022/05/05 10:54
 **/
public class MyLinkedList<E> {
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

    /**头节点*/
    private Node head;
    /*链表长度*/
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
       add(size, e);
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void add(int index, E e) {
        if (index <0 || index > size) {
            throw new IllegalArgumentException("Illegal index");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            pre.next = new Node(e, pre.next);

            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head ");
        Node temp = head;
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
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 16; i++) {
            myLinkedList.addLast(i);
            System.out.println(myLinkedList);
        }
        myLinkedList.add(3, 50);
        System.out.println(myLinkedList);
    }
}
