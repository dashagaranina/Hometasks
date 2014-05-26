import java.util.Scanner;

public class task30 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String team[] = {sc.next(),sc.next(),sc.next()};
        for(int i = 0; i < 3; i++){
			Thread t = new Thread(new MyRunnable(team[i])));
			t.start();
        }
    }
}