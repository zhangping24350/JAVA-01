package training.thread;

import kotlin.jvm.internal.Lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用Callable
 *
 * @author ping.zhang
 */
public class Method8 {

    public static void main(String[] args) throws Exception {

        //普通写法
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        Callable<Integer> callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return Calculate.sum(36);
            }
        };
        Integer sum = callable.call();
        System.out.println("普通写法异步计算结果为：" + sum);
        long current = System.currentTimeMillis();
        System.out.println("使用时间：" + (current - start) + " ms");

        //使用Lambda表达式
        Callable<Integer> callable1 = () -> Calculate.sum(36);
        // 确保 拿到result 并输出
        Integer sum1 = callable1.call();
        System.out.println("Lambda异步计算结果为：" + sum1);
        long current1 = System.currentTimeMillis() - current;
        System.out.println("使用时间：" + current1 + " ms");
        // 然后退出main线程


    }
}
