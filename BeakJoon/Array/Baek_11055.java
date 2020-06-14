import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Baek_11055 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		int sum[] = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		sum[0] = arr[0];
		for (int i = 1; i < size; i++) {
			sum[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (sum[i] < sum[j] + arr[i]) {
						sum[i] = sum[j] + arr[i];
					}
				}
			}
		}
		for (int i : sum) {
			if (answer < i)
				answer = i;
		}
		System.out.println(answer);
	}
}