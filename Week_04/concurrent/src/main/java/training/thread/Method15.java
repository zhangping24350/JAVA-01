package training.thread;


import java.util.concurrent.*;

/**
 * 使用阻塞队列
 *
 * @author ping.zhang
 */
public class Method15 {
    //阻塞队列大小为1
    private static final ArrayBlockingQueue<Integer> BLOCKING_QUEUE = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            int sum = Calculate.sum(36);
            try {
                BLOCKING_QUEUE.put(sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //阻塞获取结果
        Integer sum = BLOCKING_QUEUE.take();
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
