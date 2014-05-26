import java.util.concurrent.CountDownLatch;


public class Perfom implements Runnable{
    CountDownLatch latch;

    public Perfom(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
        latch.await();
        System.out.println("Start!");
    }  catch (InterruptedException e){
             e.printStackTrace();
        }
    }
}
