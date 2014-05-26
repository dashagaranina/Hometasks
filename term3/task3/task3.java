import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class task3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader("in.txt"));
			out = new BufferedWriter(new FileWriter("out.txt"));
			Set<String> set = new HashSet<>();
			String a;
			while ((a = in.readLine()) != null) {
				set.add(a);
			}
			for (String n : set) {
				out.write(n + '\n');

			}
			System.out.println("Уииии!");

		} finally {
			if (in != null) {
				in.close();
			}
		}
		out.close();
	}
}
