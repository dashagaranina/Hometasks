package sample;

/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 02.11.13
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class MyRunnable implements Runnable {
    String name;

    public MyRunnable (String name ){
        this.name=name;
    }

    public String getName (){
        return name;
    }

  public void run() {
         for (int i=0;i<20; i++ ){
             System.out.println(name+i);
         }
    }
}
