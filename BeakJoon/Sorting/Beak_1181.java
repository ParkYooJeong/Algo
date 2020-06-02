import java.util.*;
import java.io.*;

public class Beak_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(sc.readLine());
		String arr[] = new String[num];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.readLine();
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				if (a.length() == b.length()) {
					return a.compareTo(b);
				} else
					return Integer.compare(a.length(), b.length());
			}
		});
		System.out.println(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (!arr[i - 1].equals(arr[i]))
				System.out.println(arr[i]);
		}

	}

}
