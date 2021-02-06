package training.thread;


import java.util.concurrent.*;

/**
 * Executor与CompletionService区别：
 * Executor中task不一定按加入顺序执行完成
 * CompletionService内部维护了task顺序的Queue
 *
 *
 * @author ping.zhang
 */
public class Method14 {

    private static final Integer sum = null;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletionService<Integer> completionService = new ExecutorCompletionService(executorService);
        completionService.submit(() -> Calculate.sum(36));
        Integer sum = completionService.take().get();
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
        executorService.shutdown();
    }
}
