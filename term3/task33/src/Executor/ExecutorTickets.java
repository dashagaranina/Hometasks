package Executor;


import java.util.concurrent.*;

public class ExecutorTickets implements Callable<Integer> {
    int start;
    int end;

    public ExecutorTickets (int start, int end) {
       this.start=start;
       this.end=end;
    }
    @Override
    public Integer call() throws Exception {
        int count =0;
        for (int i = start; i <end; i++) {
            if (isLucky(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorTickets  et1 = new ExecutorTickets(0, 333333);
        ExecutorTickets et2 = new ExecutorTickets(333333,666666);
        ExecutorTickets et3 = new ExecutorTickets(666666,1000000);

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
