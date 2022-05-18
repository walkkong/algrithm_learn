package queue;

/**
 * @author liyanan
 * @date 2022/05/02 17:48
 **/
public class Main {

    private static double testQueue(Queue<Integer> q, int opCount) {
        // more
        long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            q.enquque(i);
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0;
    }

    public static void main(String[] args) {
        int opCount = 1_000_000;
        Queue<Integer> arrayQueue = new ArrayQueue<>(opCount);
        double arrayQueueTime = testQueue(arrayQueue, opCount);
        LoopQueue<Integer> loopQueue = new LoopQueue<>(opCount);
        double loopQueueTime = testQueue(loopQueue, opCount);

        System.out.println("array queue time is :" + arrayQueueTime);
        System.out.println("loop queue time is :" + loopQueueTime);
    }
}
