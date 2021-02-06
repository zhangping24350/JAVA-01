package training.thread;

import java.util.concurrent.*;

/**
 *  Java CompletableFuture 异步
 *
 * @author ping.zhang
 */
public class Method3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 确保 拿到result 并输出
        Integer sum = CompletableFuture
                .supplyAsync(() -> Calculate.sum(36))
                .get();
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
