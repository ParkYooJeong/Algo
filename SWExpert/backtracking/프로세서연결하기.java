package samsung01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static int N, core;
	static int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int minline = 10000000;
	static int maxcore = 0;
	static ArrayList<int[]> al;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= test; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			minline = 10000000;
			al = new ArrayList<int[]>();
			core = 0;
			maxcore = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						al.add(new int[] { i, j });
						core++;
					}
				}
			}
			dfs(map, 0, 0, 0);
			sb.append("#").append(t).append(" ").append(minline).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int[][] map, int index, int count, int total) {
		// 맥스코어갯수
		if (index == core) {
			if (maxcore < count) {
				maxcore = count;
				minline = total;
			} else if (maxcore == count) {
				minline = minline > total ? total : minline;
			}
			return;
		}
		int[] arr = al.get(index);
		int x = arr[0];
		int y = arr[1];

		for (int k = 0; k < 4; k++) {
			if (x == 0 || y == 0 || x == N - 1 || y == N - 1) {// 끝에것은 4번 안돌아도됨
				dfs(map, index + 1, count + 1, total);
				return;
			}

			int res = check(k, x, y, map);// 전선놓을수 있는지 확인

			if (res != 0) {
				dfs(map, index + 1, count + 1, total + res);
				int dx = x;
				int dy = y;
				for (int j = 0; j < res; j++) {
					dx += d[k][0];
					dy += d[k][1];
					map[dx][dy] = 0;

				}
			}
		}
		// 연결안됨
		dfs(map, index + 1, count, total);
	}


	private static int check(int k, int i, int j, int[][] map) {
		int count = 0;
		int dx = i;
		int dy = j;
		for (int l = 0; l < N; l++) {
			dx += d[k][0];
			dy += d[k][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
				return count;
			}
			if (map[dx][dy] != 0) {
				dx = i;
				dy = j;
				for (int n = 0; n < count; n++) {
					dx += d[k][0];
					dy += d[k][1];
					map[dx][dy] = 0;
				}
				return 0;
			}
			map[dx][dy] = 2;
			count++;
		}
		return count;
	}

}