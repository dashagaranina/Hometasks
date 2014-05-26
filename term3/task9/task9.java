package task9;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class task9 {
	public static void main(String[] args) throws IOException {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader("input.txt"));
			ArrayList<Integer> mtrx = new ArrayList<>(); //считываю все в ArrayList
			while (sc.hasNext()) {
				mtrx.add(sc.nextInt());
			}

			int n = (int) Math.sqrt(mtrx.size()); //узнаю размерность матрицы
			int m = 0;
			int[][] matrix = new int[n][n]; //Создаю матрицу
			while (m < mtrx.size()) {       //считываю туда все из ArrayList'а 
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						matrix[i][j] = mtrx.remove(m);
					}
				}
			}
			int s1 = 0, s2 = 0, s3 = 0; //проверяю на "магию"

			for (int i = 0; i < n; i++) {
				s1 += matrix[i][i];
			}
			boolean f = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					s2 += matrix[i][j];
					s3 += matrix[j][i];
				}
				if (s1 != s2 && s2 != s3) {
					f = false;
					break;

				}

				s2 = 0;
				s3 = 0;
			}
			if (f) {
				System.out.println("yes");
			} else
				System.out.println("no");

		} finally {
				sc.close();
		}

	}
}