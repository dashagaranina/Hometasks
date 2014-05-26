package task31;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 14.11.13
 * Time: 11:37
 * To change this template use File | Settings | File Templates.
 */
public class RunnableResaultHolder {
    private final static AtomicInteger amount1 = new AtomicInteger();
    private final static AtomicInteger amount2 = new AtomicInteger();
    private final static AtomicInteger amount3 = new AtomicInteger();

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    String fileName = "file1.txt";
                    amount1.set(search(fileName));

                } catch (IOException e) {
                    System.out.println("IOException");
                }
                }


        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String fileName2 = "file2.txt";
                    amount2.set(search(fileName2));

                } catch (IOException e) {
                    System.out.println("IOException");
                } }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String fileName3 = "file3.txt";
                    amount3.set(search(fileName3));

                } catch (IOException e) {
                    System.out.println("IOException");
                } }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("t1 "+amount1);
        System.out.println("t2 "+amount2);
        System.out.println("t3 "+amount3);


    }
    public static int search (String fileName) throws  IOException {
        File file = new File("src/"+fileName);
		Scanner sc = new Scanner(file);
        int c = 0;
        while(sc.hasNext()) {
			String s = sc.next();
            c++;
        }
        return c;
    }

}
