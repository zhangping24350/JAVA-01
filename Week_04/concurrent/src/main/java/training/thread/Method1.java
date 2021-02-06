package training.thread;


/**
 * volatile 自旋等待结果
 *
 * @author ping.zhang
 */
public class Method1 {


    static volatile Integer sum = 0;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            sum = Calculate.sum(36);
        }).start();

        // 确保 拿到result 并输出
        for (; ; ) {
            if (sum != 0) {
                System.out.println("异步计算结果为：" + sum);
                break;
            }
        }

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
