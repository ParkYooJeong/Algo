package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
	static int[][] d = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };// 우상좌하(시계)
	static int R, C;

	public static void main(String[] args) throws IOException {
		int[] clock = { 0, 1, 2, 3 };
		int[] anticlock = { 0, 3, 2, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		int[][] cleaner = new int[2][2];

		int count = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1) {// 공기청정기 좌표 저장
					cleaner[count][0] = i;
					cleaner[count][1] = j;
					count++;
				}
			}
		}
		
		while (T > 0) {
			T--;

			int[][] newmap = new int[R][C];
			newmap[cleaner[0][0]][cleaner[0][1]] = -1;
			newmap[cleaner[1][0]][cleaner[1][1]] = -1;

			// 확산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						diffusion(map[i][j], newmap, i, j);
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				map[i] = newmap[i].clone();
			}
			
			//회전
			rotation(clock, newmap, map, cleaner[0][0], cleaner[0][1]);
			rotation(anticlock, newmap, map, cleaner[1][0], cleaner[1][1]);

		}
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				answer += map[i][j] > 0 ? map[i][j] : 0;
			}
		}
		System.out.println(answer);

	}

	private static void diffusion(int dust, int[][] newmap, int x, int y) {
		int count = 0;

		for (int i = 0; i < 4; i++) {
			int dx = x + d[i][0];
			int dy = y + d[i][1];

			if (dx < 0 || dy < 0 || dx >= R || dy >= C || newmap[dx][dy] == -1)
				continue;

			newmap[dx][dy] += dust / 5;
			count++;
		}
		newmap[x][y] += dust - dust / 5 * count;
	}

	private static void rotation(int[] clock, int[][] newmap, int[][] map, int sx, int sy) {
		int dust = newmap[sx][sy];
		map[sx][sy] = 0;

		for (int i = 0; i < 4; i++) {
			int dir = clock[i];

			while (true) {
				int dx = sx + d[dir][0];
				int dy = sy + d[dir][1];

				if (dx < 0 || dy < 0 || dx >= R || dy >= C || newmap[dx][dy] == -1)
					break;
				map[dx][dy] = dust;
				dust = newmap[dx][dy];

				sx = dx;
				sy = dy;
			}
		}
	}
}
