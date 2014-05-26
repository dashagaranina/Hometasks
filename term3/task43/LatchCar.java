import java.util.concurrent.CountDownLatch;

public class LatchCar {
    public static void main (String[] args) throws InterruptedException {
        int n = 5;
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch finishGate = new CountDownLatch(1);
        for (int i = 0; i < n; i++) {
            Thread t = new Thread("Car #" + i) {
                public void run() {
                    try {
                        //ждем стартовой команды
                        startGate.await();
                        for (int i = 0; i < 20; i++){
                            System.out.printf("%s Lap %d%n", getName(), i);
                        }
                        finishGate.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        //одновременный старт
        long time = System.nanoTime();
        startGate.countDown();
        finishGate.await();
        time=System.nanoTime() - time;
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\first car time      " + time);

    }
}