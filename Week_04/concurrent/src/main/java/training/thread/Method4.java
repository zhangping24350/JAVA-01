package training.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用 countDownLatch
 *
 * @author ping.zhang
 */
public class Method4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger sum = new AtomicInteger(0);
        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            sum.set(Calculate.sum(36));
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        // 确保 拿到result 并输出
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
