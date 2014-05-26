package task31;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 14.11.13
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */


public class ExecutorStudents implements Callable<Integer> {
    String fileName;

    public ExecutorStudents (String fileName) {
        this.fileName=fileName;
    }
    @Override
    public Integer call() throws Exception {
        File file = new File("src/"+fileName);
        //FileReader in = new FileReader(file);
        int c = 0; int k=0;
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            String s = sc.next();
            s = sc.next();
            c+=sc.nextInt();
            k++;
        }
        c/=k;
        return c;
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorStudents  et1 = new ExecutorStudents("file1.txt");
        ExecutorStudents et2 = new ExecutorStudents("file2.txt");
        ExecutorStudents et3 = new ExecutorStudents("file3.txt");

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
