package training.thread;

import java.util.concurrent.*;

/**
 * 线程池submit获取结果
 *
 * @author ping.zhang
 */
public class Method2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // 确保 拿到result 并输出
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return Calculate.sum(36);
            }
        });
        Integer sum = submit.get();
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        executorService.shutdown();
        // 然后退出main线程
    }
}
