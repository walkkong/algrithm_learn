package sort;

import linequery.ArrayGenerator;

/**
 * @author liyanan
 * @date 2022/04/17 14:14
 **/
public class InsertionSort {
    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // arr[i] 插入到合适的位置
            for (int j = i; j >= 1; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    // 此时已经有序，不需要继续比较
                    break;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        // 书写上的优化
        for (int i = 0; i < arr.length; i++) {
            // arr[i] 插入到合适的位置
            for (int j = i; j >= 1 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将 arr[i] 暂存起来，将比 arr[i] 大的元素直接后移（采用赋值操作），并将对应移动的坐标记录下来，这里用的是 j。
            E t = arr[i];
            int j;
            for (j = i; j >= 1 && arr[j - 1].compareTo(t) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            // j 记录的位置就是 t 此次应该插入的位置。
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort4(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }


    private static <E> void swap(E[] arr, int i, int minIndex) {
        E temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10_000, 100_000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(InsertionSort.class, arr);
        }

       /* System.out.println("Order Array:");
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateOrderedArray(n);
            SortingHelper.sortTest(InsertionSort.class, arr);
        }*/
    }
}
