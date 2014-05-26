
public class MyRunnable implements Runnable{
    private String team;
    public MyRunnable(String team){
        this.team = team;
    }
    public void run(){
        for(int i = 1; i < 5; i++){
             for(int j = 0; j < 5; j++){
                System.out.println("#"+i+","+team+","+j*10);
             }
        }
    }
}