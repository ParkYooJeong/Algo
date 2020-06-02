import java.io.*;
import java.util.*;

public class Beak_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(sc.readLine());
		int arr[] = new int[num];
		int sum = 0;
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sc.readLine());
		}
		int min = arr[0];
		int max = arr[0];

		Arrays.sort(arr);
		for (int i = 0; i < num; i++) {
			if (min > arr[i])
				min = arr[i];
			else if (max < arr[i])
				max = arr[i];

			if (count.containsKey(arr[i])) {
				count.replace(arr[i], count.get(arr[i]) + 1);
			} else {
				count.put(arr[i], 1);
			}
			sum += arr[i];
		}

		int countmax = 0;
		int index = 0;
		for (int i : count.keySet()) {
			if (countmax < count.get(i)) {
				countmax = count.get(i);
				index = i;
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i : count.keySet()) {
			if (countmax == count.get(i)) {
				al.add(i);
			}
		}
		al.sort(null);

		bw.write(Math.round((double) sum / num) + "\n");
		bw.write(arr[num / 2] + "\n");
		if (al.size() > 1) {
			bw.write(al.get(1) + "\n");
		} else {
			bw.write(al.get(0) + "\n");
		}
		if (num == 1) {
			bw.write(0 + "\n");
		} else {
			bw.write(max - min + "\n");
		}

		bw.flush();
		bw.close();
	}
}