package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼 {
	static int N, M, K;
	static int[][] d = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] dir = { { 0, 2, 4, 6 }, { 1, 3, 5, 7 } };
		
		Queue<Ball> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			q.add(new Ball(r, c, m, d, s));
		}
		int[][][] map = new int[N ][N ][4];

		while (!q.isEmpty() && K > 0) {
			map = new int[N + 1][N + 1][4];// 카운트, 질량, 속력, 나머지값
			K--;
			// 이동
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Ball b = q.poll();
				int r = (b.r + d[b.d][0] * b.s + N * b.s) % N;
				int c = (b.c + d[b.d][1] * b.s + N * b.s) % N;
				map[r][c][0]++;
				map[r][c][1] += b.m;
				map[r][c][2] += b.s;
				map[r][c][3] += b.d % 2;
				q.add(new Ball(r, c, b.m, b.d, b.s));
			}

			// 같은 칸 있는지 확인

			for (int i = 0; i < size; i++) {
				Ball b = q.poll();// 같은 칸에 여러개 있으면 다 빼줌

				if (map[b.r][b.c][0] == 1) {//하나밖에없으면 다시 넣어줌
					q.add(b);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][0] > 1) {//같은칸에 여러개 있으면 4개로 나눔
						if (map[i][j][1] / 5 == 0) {// 질량이 0이면 사라짐
							map[i][j][1] = 0;
							continue;
						}
						if (map[i][j][3] == map[i][j][0] || map[i][j][3] == 0) {//
							for (int k = 0; k < 4; k++) {
								q.add(new Ball(i, j, map[i][j][1] / 5, dir[0][k], map[i][j][2] / map[i][j][0]));
							}
						} else {
							for (int k = 0; k < 4; k++) {
								q.add(new Ball(i, j, map[i][j][1] / 5, dir[1][k], map[i][j][2] / map[i][j][0]));
							}
						}
						map[i][j][1] = map[i][j][1] / 5 * 4;
					}
				}
			}

		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j][1];
			}
		}
		System.out.println(sum);
	}
}

class Ball{
	int r;
	int c;
	int m;
	int d;
	int s;

	public Ball(int r, int c, int m, int d, int s) {
		super();
		this.r = r;
		this.c = c;
		this.m = m;
		this.d = d;
		this.s = s;
	}
}
