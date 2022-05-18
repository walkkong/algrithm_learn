package sort;

import linequery.ArrayGenerator;

/**
 * @author liyanan
 * @date 2022/04/12 18:20
 **/
public class SelectionSort {
    private SelectionSort(){}


    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i .. n) 最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // arr[minIndex] 和 arr[i] 交换
            swap(arr, i, minIndex);
        }
    }
    
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            // arr[0, i] 中的最大值
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[maxIndex].compareTo(arr[j]) < 0) {
                    maxIndex = j;
                }
            }
            // arr[maxIndex] 和 arr[i] 交换
            swap(arr, i, maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int minIndex) {
        E temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
       /* Integer[] arr = ArrayGenerator.generateRandomArray(10);
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        Student[] students = {new Student("张三", 17, 95),
                new Student("李四", 17, 88),
                new Student("王五", 18, 90)};

        System.out.println(Arrays.toString(students));
        SelectionSort.sort(students);
        System.out.println(Arrays.toString(students));*/

        int[] dataSize = {10_000, 100_000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(SelectionSort.class, arr);
        }
        // n 提升 10 倍，算法性能查了近 100 倍。
     /*   arr = ArrayGenerator.generateRandomArray(100_000, bound);
        startTime = System.nanoTime();
        SelectionSort.sort(arr);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000000.0);*/
    }
}
