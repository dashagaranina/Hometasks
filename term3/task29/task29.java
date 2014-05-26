package sample;

/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 02.11.13
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
public class task29 {
   public static void main (String[] args) {
      MyRunnable mr = new MyRunnable("car");
       for (int i=0; i<5; i++){
             Thread t = new Thread(mr, "car"+i);
           t.start();
       }

   }

}
