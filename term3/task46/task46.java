import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class task46 {

    public static void main(String... args) {
        final AtomicInteger result = new AtomicInteger();
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            public void run() {
                System.out.println("All lucky tickets: " + result);
            }
        });
        new Thread(new Task(barrier, result, 000000, 333333)).start();
        new Thread(new Task(barrier, result, 333334, 666666)).start();
        new Thread(new Task(barrier, result, 666667, 999999)).start();
    }
}