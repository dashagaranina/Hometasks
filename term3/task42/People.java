import java.util.concurrent.CountDownLatch;

public class People implements Runnable {

    CountDownLatch latch;
    String num;

    public People(String num, CountDownLatch latch) {
        this.latch = latch;
        this.num = num;
    }

    @Override
    public void run() {
         latch.countDown();
         System.out.println(num + " I'm here!");
    }
}
