package training.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * 使用ForkJoinPool
 *
 * @author ping.zhang
 */
public class Method12 {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> submit = commonPool.submit(() -> Calculate.sum(36));

        Integer sum = submit.get();
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
