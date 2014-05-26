package task31;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 14.11.13
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */


public class ExecutorFiles implements Callable<Integer> {
    String fileName;

    public ExecutorFiles (String fileName) {
        this.fileName=fileName;
    }
    @Override
    public Integer call() throws Exception {
        File file = new File("src/"+fileName);
		Scanner sc = new Scanner(file);
        int c = 0;
        while(sc.hasNext()) {
			String s = sc.next();
            c++;
        }
        return c;
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorFiles  et1 = new ExecutorFiles("file1.txt");
        ExecutorFiles et2 = new ExecutorFiles("file2.txt");
        ExecutorFiles et3 = new ExecutorFiles("file3.txt");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future f1 = executor.submit(et1);
        Future f2 = executor.submit(et2);
        Future f3 = executor.submit(et3);
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();


    }
}
