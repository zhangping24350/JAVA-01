package training.thread;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;

/**
 * 使用Exchanger交换数据
 *
 * @author ping.zhang
 */
public class Method13 {

    private static final Exchanger<Integer> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            int sum = Calculate.sum(36);
            try {
                Integer exchange = EXCHANGER.exchange(sum);
                System.out.println("Main 线程交换数据:" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //交换的子线程结果
        Integer sum = EXCHANGER.exchange(1);
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
