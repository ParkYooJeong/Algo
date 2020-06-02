import java.io.*;
import java.util.*;

public class Beak_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = sc.readLine();
		String arr[] = str.split("");

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].charAt(0) < arr[j + 1].charAt(0)) {
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (String i : arr) {
			bw.write(i);
		}

		bw.flush();
		bw.close();
	}

}
