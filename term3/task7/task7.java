package task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class task7 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = null;

		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new BufferedWriter(new FileWriter("output.txt"));
			sc = new Scanner(new FileReader("input.txt"));
			Set<Students> set = new TreeSet<>();
			while (sc.hasNext()) {
				String name = sc.next();
				int mark = sc.nextInt();
				set.add(new Students(name, mark));
			}
			
			Iterator<Students> iter = set.iterator();
			
			for (int i = 0; i < 9; i++) {
				if (iter.hasNext()) {
				out.write(iter.next().toString() +"\n");
				}
			}

			System.out.println("уиии!");

		} finally {
			if (out != null) {
				out.close();
				sc.close();
				in.close();
			}

		}
	}
}
