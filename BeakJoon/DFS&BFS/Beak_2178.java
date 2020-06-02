import java.util.*;
import java.io.*;

class point {
	int x;
	int y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;

	}
}

public class Beak_2178 {
	static int arr[][];

	static boolean check(int m, int n) {
		if (m < 0 || n < 0 || m >= arr.length || n >= arr[0].length)
			return false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = "";
		Queue<point> q = new LinkedList<point>();

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		arr = new int[a][b];
		boolean visit[][] = new boolean[a][b];

		int[] d = new int[] { -1, 0, 1, 0 };
		int[] d2 = new int[] { 0, -1, 0, 1 };

		for (int i = 0; i < a; i++) {
			s = br.readLine();
			for (int j = 0; j < b; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		visit[0][0] = true;
		q.add(new point(0, 0));

		while (!q.isEmpty()) {
			point p = q.poll();
			if (p.x == arr.length - 1 && p.y == arr[0].length - 1) {
				System.out.println(arr[p.x][p.y]);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int m = p.x + d[i];
				int n = p.y + d2[i];

				if (!check(m, n) || visit[m][n] || arr[m][n] == 0)
					continue;

				visit[m][n] = true;
				arr[m][n] = arr[p.x][p.y] + 1;
				q.add(new point(m, n));
			}

		}

	}
}