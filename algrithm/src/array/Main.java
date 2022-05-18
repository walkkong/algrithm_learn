package array;

/**
 * @author liyanan
 * @date 2022/04/18 10:19
 **/
public class Main {
    public static void main(String[] args) {
    /*    int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int[] scores = new int[]{100, 99, 66};
        for(int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
*/
        DynamicArray<Integer> array = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);

        System.out.println(array.get(5));
        array.set(5, 6);
        System.out.println(array.get(5));

        System.out.println("开始删除：");
        Integer remove = array.remove(1);
        System.out.println(array);
        System.out.println(remove);

        System.out.println(array);
        System.out.println(array.removeFirst());
        System.out.println(array.removeFirst());
        System.out.println(array.removeFirst());
        System.out.println(array.removeFirst());
        System.out.println(array.removeFirst());
        System.out.println(array.removeFirst());
        System.out.println(array.removeLast());
        System.out.println(array);
    }
}
