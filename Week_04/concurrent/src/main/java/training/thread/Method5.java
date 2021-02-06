package training.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用CyclicBarrier
 *
 * @author ping.zhang
 */
public class Method5 {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        long start = System.currentTimeMillis();

        AtomicInteger sum = new AtomicInteger(0);
        // 在这里创建一个线程或线程池，
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
            sum.set(Calculate.sum(36));
        });
        cyclicBarrier.await();
        // 确保 拿到result 并输出
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
