package task6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class task6 {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				"input.txt"), "US-ASCII");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
				"output.txt"), "UTF-16");
		try {
			int c;
			while ((c = isr.read()) != -1) {
				osw.write(c);
			}
		} finally {
			if (isr != null) {
				isr.close();
				osw.close();
			}
		}

	}
}
