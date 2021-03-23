package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼 {
	static int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int ice = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int N = (int) Math.pow(2, n);
		int Q = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			int level = (int) Math.pow(2, L);

			// 시계방향 회전
			for (int j = 0; j < N; j += level) {
				for (int k = 0; k < N; k += level) {
					rotation(map, level, j, k);
				}
			}

			int[][] mapcopy = new int[N][N];
			for (int j = 0; j < map.length; j++) {
				mapcopy[j] = map[j].clone();
			}
			
			// 얼음 녹이기
			for (int j = 0; j < N; j ++) {
				for (int k = 0; k < N; k ++) {
					if (map[j][k]>0&&!melt(map, j, k, N)) {
						mapcopy[j][k]--;
					}
				}
			}

			for (int j = 0; j < mapcopy.length; j++) {
				map[j] = mapcopy[j];
			}
		}
		
		
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
			}
		}
		
		int max = 0;
		boolean[][] visit = new boolean[N][N];
		//큰덩어리 칸 갯수 세기
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] > 0 && !visit[i][j]) {
					ice = 0;
					visit[i][j]=true;
					dfs(map, visit, i, j, N);
					max = max < ice ? ice : max;
				}
			}
		}
		

		System.out.println(sum);
		System.out.println(max);

	}

	// 시계방향 90도 회전
	private static void rotation(int[][] map, int level, int x, int y) {
		int N = x + level - 1;
		for (int i = x; i < x + level / 2; i++) {// 위아래 뒤집기
			for (int j = y; j < y + level; j++) {
				int temp = map[i][j];
				map[i][j] = map[N - i + x][j];
				map[N - i + x][j] = temp;
			}
		}

		for (int i = x; i < x + level; i++) {// 대각선 바꾸기
			for (int j = y + i - x + 1; j < y + level; j++) {
				int temp = map[i][j];
				map[i][j] = map[x + j - y][y + i - x];// 계산 조심..
				map[x + j - y][y + i - x] = temp;
			}
		}
	}

	private static boolean melt(int[][] map, int x, int y, int N) {
		int count = 0;
		
		for (int i = 0; i < 4; i++) {
			int dx = x + d[i][0];
			int dy = y + d[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= N)
				continue;
			
			if (map[dx][dy] > 0)
				count++;
		}
		
		if (count >= 3)
			return true;
		
		return false;
	}

	private static void dfs(int[][] map, boolean[][] visit, int x, int y, int N) {
		ice++;
		for (int i = 0; i < 4; i++) {
			int dx = x + d[i][0];
			int dy = y + d[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= N||visit[dx][dy])
				continue;

			if (map[dx][dy] > 0 ) {
				visit[dx][dy] = true;
				dfs(map, visit, dx, dy, N);
			}
		}
	}
}
