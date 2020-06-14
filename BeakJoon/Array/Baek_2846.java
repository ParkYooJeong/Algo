import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Baek_2846 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		for (int i = 1; i < size; i++) {
			int max = 0; int min = 0;
			
			if (arr[i - 1] < arr[i]) {
				min = arr[i - 1];
				max = arr[i];
				for (; i < size - 1; i++) {
					if (arr[i] < arr[i + 1]) {
						max = arr[i + 1];
					} else
						break;
				}
				if (answer < max - min)
					answer = max - min;

			}
		}
		System.out.println(answer);
	}
}