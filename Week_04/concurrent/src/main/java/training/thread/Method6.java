package training.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * 使用FutureTask
 *
 * @author ping.zhang
 */
public class Method6 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return Calculate.sum(36);
            }
        });
        // 确保 拿到result 并输出
        new Thread(futureTask).start();

        Integer sum = futureTask.get();
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
