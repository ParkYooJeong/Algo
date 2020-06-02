import java.io.*;
import java.util.*;

class Beak_2667 {
	static int[][] connect;
	static int count;
	static int cnt[];
	static int size;
	static boolean[][] visit;

	static void dfs(int starti, int startj) {
		visit[starti][startj] = true;
		if ((starti + 1) < size && connect[starti + 1][startj] == 1 && !visit[starti + 1][startj]) {
			count++;
			dfs(starti + 1, startj);
		}
		if ((startj + 1) < size && connect[starti][startj + 1] == 1 && !visit[starti][startj + 1]) {
			count++;
			dfs(starti, startj + 1);
		}
		if (startj > 0 && connect[starti][startj - 1] == 1 && !visit[starti][startj - 1]) {
			count++;
			dfs(starti, startj - 1);
		}
		if (starti > 0 && connect[starti - 1][startj] == 1 && !visit[starti - 1][startj]) {
			count++;
			dfs(starti - 1, startj);
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		connect = new int[size][size];
		visit = new boolean[size][size];
		cnt = new int[size * size];
		int index = 0;
		String s = "";

		for (int i = 0; i < size; i++) {
			s = br.readLine();
			for (int j = 0; j < size; j++)
				connect[i][j] = s.charAt(j) - '0';
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (connect[i][j] == 1 && !visit[i][j]) {
					count = 1;
					dfs(i, j);
					cnt[index++] = count;
				}
			}
		}

		System.out.println(index);
		Arrays.sort(cnt);

		for (int i = cnt.length - index; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}
}
