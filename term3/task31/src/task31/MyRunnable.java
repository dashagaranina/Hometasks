package task31;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 14.11.13
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public class MyRunnable implements Runnable {
    private String fileName;

    public MyRunnable (String fileName) {
        this.fileName=fileName;
    }

    public void run() {
        try {

            int c = search(fileName);
            System.out.println(fileName+" длина файла = "+c );
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public int search (String fileName) throws FileNotFoundException, IOException {
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
