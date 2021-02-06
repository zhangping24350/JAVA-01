package training.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用wait notify
 *
 * @author ping.zhang
 */
public class Method9 {

    public static void main(String[] args) throws Exception {
        AtomicInteger sum = new AtomicInteger(0);
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            synchronized (sum) {
                sum.set(Calculate.sum(36));
                sum.notify();
            }
        }).start();

        synchronized (sum) {
            sum.wait();
        }
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
