import java.util.*;
import java.io.*;

public class Beak_2580 {
	static int[][] arr = new int[9][9];
	static int row = 0;
	static int col = 0;

	static boolean check() {// 0있나체크
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == 0) {
					row = i;
					col = j;
					return false;
				}
			}
		}
		return true;
	}

	static boolean linerow(int m, int n) {
		// 가로로 체크
		for (int i = 0; i < 9; i++) {
			if (arr[m][i] == n) {
				return false;
			}
		}

		return true;
	}

	static boolean linecol(int m, int n) {
//세로로 체크
		for (int i = 0; i < 9; i++) {
			if (arr[i][m] == n) {
				return false;
			}
		}

		return true;
	}

	static boolean squre(int m, int n, int k) {// 박스체크
		for (int i = m; i < m + 3; i++) {
			for (int j = n; j < n + 3; j++) {
				if (arr[i][j] == k) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean fill() {
		int r = 0;
		int c = 0;
		if (check())
			return true;

		r = row;
		c = col;

		for (int i = 1; i <= 9; i++) {
			if (squre(r / 3 * 3, c / 3 * 3, i) && linecol(c, i) && linerow(r, i)) {
				arr[r][c] = i;
				if (fill()) {
					return true;
				}
				arr[r][c] = 0;
			}
		}
		return false; // 넣을게없으면 실패
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		fill();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j < 8)
					bw.write(arr[i][j] + " ");
				else
					bw.write(arr[i][j] + "");
			}
			bw.newLine();
		}
		bw.flush();
	}
}
