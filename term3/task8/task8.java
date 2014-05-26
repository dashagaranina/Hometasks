package task8;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class task8 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = null;

		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new BufferedWriter(new FileWriter("output.txt"));
			sc = new Scanner(new FileReader("input.txt"));
			Map<String, Integer> map = new TreeMap<>();
			while (sc.hasNext()) {
				String name = sc.next();
				int mark = sc.nextInt();
				map.put(name, mark);
			}
			
			for (Map.Entry<String, Integer> e : map.entrySet()) {
				out.write(e.getKey()+ " " + e.getValue());
				out.newLine();
			}
		} finally {
			if (in!=null && out!=null) {
				in.close();
				out.close();
				
			}
			sc.close();
		}
		
	}
}

