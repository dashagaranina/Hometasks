import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class task4 {
	public static void main(String[] args) throws IOException {
		Random r = new Random(10000);
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader("in.txt"));
			out = new BufferedWriter(new FileWriter("in.txt"));
			for (int i = 0; i < 100000; i++) {
				out.write(r.nextInt() + "\n");
			}
			out.flush();
			Map<String, Integer> map = new HashMap<>();
			String str;
			Map<String, Integer> tree = new TreeMap<>();
			int i = 0;
			while ((str = in.readLine()) != null) {
				map.put(str, i);
				tree.put(str, i);

			}
			String search = r.nextInt() + " ";
			long start1 = System.nanoTime();
			map.get(search);
			long end1 = System.nanoTime();

			String search2 = r.nextInt() + " ";
			long start2 = System.nanoTime();
			tree.get(search2);
			long end2 = System.nanoTime();

			long time1 = end1 - start1;
			long time2 = end2 - start2;
			if (time1 > time2) {
				System.out.println("Map faster");
			} else {
				System.out.println("Tree faster");
			}
		} finally {
			if (in != null) {
				in.close();
				out.close();
			}
		}
	}
}
