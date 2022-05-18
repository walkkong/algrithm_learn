package sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liyanan
 * @date 2022/04/14 11:10
 **/
public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(Class<?> clazz, E[] arr) {
        long startTime = System.nanoTime();
        try {
            Method sortMethod = clazz.getDeclaredMethod("sort", Comparable[].class);
            sortMethod.invoke(null, (Object) arr);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("not found");
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        String sortName = clazz.getSimpleName();
        if (!SortingHelper.isSort(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.printf("%s, n = %d, time = %fs %n", sortName, arr.length, time);
    }
}
