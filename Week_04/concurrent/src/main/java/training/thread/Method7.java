package training.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用join
 *
 * @author ping.zhang
 */
public class Method7 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        AtomicInteger sum = new AtomicInteger(0);
        // 在这里创建一个线程或线程池，
        Thread thread = new Thread(() -> {
            sum.set(Calculate.sum(36));
        });
        thread.start();

        thread.join();
        // 确保 拿到result 并输出
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
