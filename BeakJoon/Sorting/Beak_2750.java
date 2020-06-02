
import java.io.*;

public class Beak_2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(sc.readLine());
		int arr[] = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sc.readLine());
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i : arr)
			System.out.println(i);
	}
}
