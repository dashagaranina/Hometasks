import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 16.12.13
 * Time: 1:50
 * To change this template use File | Settings | File Templates.
 */
public class task45 {
    volatile static int count =0;
    final static CountDownLatch start = new CountDownLatch(1);
    final static int n = 35; //количество покупателей
    final static AtomicInteger [] arr = new AtomicInteger[30];

    public static void main(String[] args) {
        for (int i = 0; i <30; i++) {
            arr[i] = new AtomicInteger(0);     //заполняем массив "свободными местами"
        }

        for  (int i=0; i<n; i++){
            final Thread thread = new Thread(){
                public void run (){
                    try {
                        start.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Random r = new Random();
                   // synchronized (arr){

                        while (count!=30){
                            int i = r.nextInt(30);
                            if (arr[i].get()==0){
                                //System.out.println("This place is free. You can buy it!");
                                if (arr[i].compareAndSet(0,1)) {
                                    System.out.println("Ticket #"+(i+1)+" bought.");
                                    count++;
                                }
                            //} else {
                             //       System.out.println("Sorry, this place is busy.");
                            }
                        }
                  //  }


                }
            };
            thread.start();
        }
        start.countDown();


    }
}
