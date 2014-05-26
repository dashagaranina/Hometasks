import java.util.concurrent.CountDownLatch;

public class LatchTest {
    public static void main (String[] args) throws InterruptedException {

        int n = 20;

        final CountDownLatch startGate = new CountDownLatch(10);

        Thread perf = new Thread(new Perfom(startGate));

        perf.start();

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new People("Person#"+i, startGate));
            t.start();
        }


    }
}
