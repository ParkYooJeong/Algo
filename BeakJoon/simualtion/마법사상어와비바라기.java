package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와비바라기 {
	static int N;

	static int[][] check_d = { { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int move = Integer.parseInt(st.nextToken());
		int[][] d = { { 0, 0 }, { 0, N - 1 }, { N - 1, N - 1 }, { N - 1, 0 }, { N - 1, 1 }, { 0, 1 }, { 1, 1 },
				{ 1, 0 }, { 1, N - 1 } };

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] cloud = new boolean[N][N];
		cloud[N - 1][0] = cloud[N - 1][1] = cloud[N - 2][0] = cloud[N - 2][1] = true;

		for (int k = 0; k < move; k++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			// 구름이동
			boolean[][] move_cloud = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cloud[i][j]) {
						int x = (i + d[dir][0] * num) % N;
						int y = (j + d[dir][1] * num) % N;
						move_cloud[x][y] = true;
						map[x][y]++;
					}
				}
			}

			// 대각선 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (move_cloud[i][j]) {
						int count = check(i, j, map);
						if (count > 0) {
							map[i][j] += count;
						}
					}
				}
			}
			// 구름생성
			cloud = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 2 && !move_cloud[i][j]) {
						cloud[i][j] = true;
						map[i][j] -= 2;
					}
				}
			}

		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);

	}

	private static int check(int i, int j, int[][] map) {
		int count = 0;
		for (int k = 0; k < 4; k++) {
			int x = i + check_d[k][0];
			int y = j + check_d[k][1];

			if (x < 0 || y < 0 || x >= N || y >= N)
				continue;
			if (map[x][y] > 0)
				count++;
		}
		return count;
	}

}
