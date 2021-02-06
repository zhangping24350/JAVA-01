package training.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用LockSupport
 *
 * @author ping.zhang
 */
public class Method11 {

    public static void main(String[] args) throws Exception {
        AtomicInteger sum = new AtomicInteger(0);
        long start = System.currentTimeMillis();
        Thread thread = Thread.currentThread();
        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            sum.set(Calculate.sum(36));
            LockSupport.unpark(thread);
        }).start();

        LockSupport.park();

        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
