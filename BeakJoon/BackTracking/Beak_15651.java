import java.util.*;
import java.io.*;

public class Beak_15651 {
	static int num2;
	static int num;
	static StringBuilder sb = new StringBuilder();

	static void ans(int[] arr, int count) {

		if (count == num2) {
			for (int i = 0; i < num2 - 1; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append(arr[num2 - 1] + "\n");
			return;
		}

		for (int i = 0; i < num; i++) {
			arr[count] = i + 1;
			ans(arr, count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		num = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());

		int arr[] = new int[num2];
		ans(arr, 0);
		bw.write(sb.toString());
		bw.flush();
	}
}
