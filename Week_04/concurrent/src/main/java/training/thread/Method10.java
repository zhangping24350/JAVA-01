package training.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock condition
 *
 * @author ping.zhang
 */
public class Method10 {

    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicInteger sum = new AtomicInteger(0);
        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            lock.lock();
            try {
                sum.set(Calculate.sum(36));
                condition.signal();
            } finally {
                lock.unlock();
            }
        }).start();

        lock.lock();
        try {
            condition.await();
            System.out.println("异步计算结果为：" + sum);
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        } finally {
            lock.unlock();
        }
        // 然后退出main线程
    }
}
