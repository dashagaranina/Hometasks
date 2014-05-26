package task31;

/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 14.11.13
 * Time: 10:49
 * To change this template use File | Settings | File Templates.
 */
public class task31 {
    public static void main (String [] args){
        Thread t1 = new Thread (new MyRunnable("file1.txt"));
        t1.start();
        Thread t2 = new Thread(new MyRunnable("file2.txt"));
        t2.start();
        Thread t3 = new Thread(new MyRunnable("file3.txt"));
        t3.start();
    }

}
