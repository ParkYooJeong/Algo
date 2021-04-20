package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트택시 {
	static int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int INF = 10000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int oil = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int taxix = Integer.parseInt(st.nextToken()) - 1;
		int taxiy = Integer.parseInt(st.nextToken()) - 1;

		int[][] passenger = new int[M + 1][4];//시작지점xy, 출발지점xy
		int[][] pass_map = new int[N][N];//고객 위치 표시

		for (int i = 1; i < passenger.length; i++) {
			st = new StringTokenizer(br.readLine());
			passenger[i][0] = Integer.parseInt(st.nextToken()) - 1;
			passenger[i][1] = Integer.parseInt(st.nextToken()) - 1;
			passenger[i][2] = Integer.parseInt(st.nextToken()) - 1;
			passenger[i][3] = Integer.parseInt(st.nextToken()) - 1;
			pass_map[passenger[i][0]][passenger[i][1]] = i;
		}

		boolean[] passenger_check = new boolean[M + 1];//태운승객 체크

		int count = 0;//승객 수
		boolean flag = true;

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}
					return o1[0] - o2[0];
				}
				return o1[2] - o2[2];
			}
		});
		
		loop: while (M > count) {
			count++;

			boolean[][] visit = new boolean[N][N];
			visit[taxix][taxiy] = true;// 택시 출발지점 체크

			pq.add(new int[] { taxix, taxiy, 0 });
			int index = 0;
			int pass_dir = 0;

			// 가까이 있는 승객 구함
			while (!pq.isEmpty()) {
				int[] arr = pq.poll();

				int x = arr[0];
				int y = arr[1];
				int len = arr[2];

				if (pass_map[x][y] != 0 && !passenger_check[pass_map[x][y]]) {// 태울 승객 찾음
					index = pass_map[x][y];
					pass_dir = len;
					passenger_check[pass_map[x][y]] = true;
					pass_map[x][y] = 0;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int dx = x + d[i][0];
					int dy = y + d[i][1];

					if (dx < 0 || dy < 0 || dx >= N || dy >= N || visit[dx][dy] || map[dx][dy] == 1)
						continue;
					visit[dx][dy] = true;
					pq.add(new int[] { dx, dy, len + 1 });
				}
			}
			pq.clear();

			// 연료 바닥남
			if (pass_dir > oil || index == 0) {
				flag = false;
				break loop;
			}

			oil -= pass_dir;
			passenger_check[index] = true;

			// 목적지까지 이동
			int use_oil = bfs(passenger[index][0], passenger[index][1], passenger[index][2], passenger[index][3], map);

			// 연료바닥남
			if (use_oil > oil || use_oil == INF) {
				flag = false;
				break loop;
			}
			//연료계산, 택시위치 갱신
			oil += use_oil;
			taxix = passenger[index][2];
			taxiy = passenger[index][3];

		}
		if (!flag)
			System.out.println(-1);
		else
			System.out.println(oil);
	}

	private static int bfs(int sx, int sy, int ex, int ey, int[][] map) {
		int N = map.length;
		boolean[][] visit = new boolean[N][N];

		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { sx, sy, 0 });

		while (!q.isEmpty()) {
			int[] arr = q.poll();

			int x = arr[0];
			int y = arr[1];
			int len = arr[2];

			if (x == ex && y == ey) {
				return len;
			}

			for (int i = 0; i < 4; i++) {
				int dx = x + d[i][0];
				int dy = y + d[i][1];

				if (dx < 0 || dy < 0 || dx >= N || dy >= N || visit[dx][dy] || map[dx][dy] == 1)
					continue;

				visit[dx][dy] = true;
				q.add(new int[] { dx, dy, len + 1 });
			}
		}
		return INF;
	}
}
