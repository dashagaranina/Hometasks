package Holder;


import java.util.concurrent.ExecutionException;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 09.11.13
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */



public class RunnableResultHolder {

    //Можно написать свой holder результата
    private final static AtomicInteger amount1 = new AtomicInteger();
    private final static AtomicInteger amount2 = new AtomicInteger();
    private final static AtomicInteger amount3 = new AtomicInteger();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                int count =0;
                for (int i = 0; i <333333; i++) {
                    if (isLucky(i)) {
                        count++;
                    }
                }
                amount1.set(count);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                int count=0;
                for (int i = 333333; i <666666; i++) {
                    if (isLucky(i)) {
                        count++;
                    }
                }
                amount2.set(count);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                int count=0;
                for (int i = 666666; i <=999999; i++) {
                    if (isLucky(i)) {
                        count++;
                    }
                }
                amount3.set(count);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        //ждем завершения работы потока
        t1.join();
        t2.join();
        t3.join();
//        System.out.println(amount1.get());
//        System.out.println(amount2.get());
//        System.out.println(amount3.get());
        int amount = amount1.get() + amount2.get() + amount3.get();
        System.out.println("Всего счастливых билетов: "+amount);
    }

    public static boolean isLucky (int i) {
        int first = 0;
        int second = 0;
        for (int j = 0; j < 3; j++) {
            first+=i%10;
            i=i/10;

        }
        for (int j = 0; j < 3; j++) {
            second+=i%10;
            i=i/10;

        }

        if (first==second){
            return true;
        } else {
            return false;
        }
    }



}




/**
 * Executor Service
 *
 * ExecutorService es = Executors.newFixedThreadPool(10);
 *
 * for (int i=0; i<0;i++){
 * rs.submit(myRunnable);
 * }
 *
 * es = Executors.newCachedThreadPool();
 * Executors.SingleThreadScheduledExecutor(); -
 * es.schedule(myRunnable, 5, TimeUnit.SECONDS);

 Future f = es.submit (callable) ;

f.get();
 *
 *
 */
