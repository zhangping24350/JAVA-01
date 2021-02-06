package training.thread;

/**
 * TODO
 *
 * @author ping.zhang
 */
public class Calculate {

    public static int sum(Integer num) {
        int fibo = fibo(num);
        return fibo;
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
