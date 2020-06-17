import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Beak_2212 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int size = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		int ans[]=new int[size-1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		for (int i = size-1; i >0; i--) {
			ans[i-1]=arr[i]-arr[i-1];
		}
		Arrays.sort(ans);
		for (int i = 0; i < size-num; i++) {
			answer += ans[i];
		}
		System.out.println(answer);
	}
}
