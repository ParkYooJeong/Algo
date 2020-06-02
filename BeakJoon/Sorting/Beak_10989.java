import java.io.*;

public class Beak_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(sc.readLine());
		int arr[] = new int[num];
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sc.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		int count[] = new int[max + 1];
		int answer[] = new int[num];

		for (int i = 0; i < num; i++) {
			count[arr[i]]++;
		}

		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
		bw.close();
	}

}