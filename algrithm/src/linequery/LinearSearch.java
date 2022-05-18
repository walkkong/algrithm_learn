package linequery;

/**
 * 实现线性查找法
 * @author liyanan
 * @date 2022/04/09 17:41
 **/
public class LinearSearch {
    /**
     * 用户不能创建 LinearSearch 对象
     */
    private LinearSearch() {
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long start = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LinearSearch.linearSearch(data, n);
            }
            long end = System.nanoTime();
            double seconds = (end - start) / 1000_000_000.0;
            System.out.println("n = " + n + ", " + seconds + " s");
        }
    }

    /**
     * 使用 static 修饰，用户不需要创建对象就调用
     * @param data
     * @param target
     * @return
     */
    public static <E> int linearSearch(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }


}
