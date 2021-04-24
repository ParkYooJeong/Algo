package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 어른상어 {
	static int[][] d = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][][] map;
	static int[][][] priority;
	static int N, M, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int time = 0;

		map = new int[N][N][3];// 상어 번호, 시간 ,방향
		priority = new int[M + 1][5][5];
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				if (map[i][j][0] != 0) {
					map[i][j][1] = k;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= M; n++) {

			loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][0] == n) {// 상어 방향
						map[i][j][2] = Integer.parseInt(st.nextToken());
						break loop;
					}
				}
			}
		}
		// 우선순위
		for (int n = 1; n <= M; n++) {
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 4; j++) {
					priority[n][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		while (time<=1000) {
			// 이동
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 상어가 있으면 어디로 이동할지 탐색
					if (map[i][j][0] != 0 && map[i][j][1] == k) {
						// 이동할 방향 넣기
						int dir = map[i][j][2];// 방향
						int num = map[i][j][0];// 상어 번호
						// 냄새 없는지 탐색
						
						boolean flag = false;
						for (int k = 1; k <= 4; k++) {
							int index = priority[num][dir][k];
							int dx = i + d[index][0];
							int dy = j + d[index][1];
							
							if (dx < 0 || dy < 0 || dx >= N || dy >= N)
								continue;
							if (map[dx][dy][0] == 0) {// 냄새 없음
								q.add(new int[] { num, dx, dy, index });
								flag = true;
								break;
							}
						}
						if (!flag) {// 냄새 없는 방향 없음. 내가 왔던방향으로 가기
							for (int k = 1; k <= 4; k++) {
								int index = priority[num][dir][k];
								int dx = i + d[index][0];
								int dy = j + d[index][1];

								if (dx < 0 || dy < 0 || dx >= N || dy >= N)
									continue;
								if (map[dx][dy][0] == num) {// 내가 왔던 방향
									q.add(new int[] { num, dx, dy, index });
									break;
								}
							}
						}

					}
				}
			}
//			System.out.println(q.size());
			if(q.size()<=1) {
				break;
			}
			//시간 줄이기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j][0]!=0) {
						if(map[i][j][1]==1) {//냄새 없애기
							map[i][j][0]=0;
							map[i][j][1]=0;
							map[i][j][2]=0;
						}
						else {
							map[i][j][1]--;
						}
					}
				}
			}
			//이동한곳 표시
			while(!q.isEmpty()) {
				int[] shark=q.poll();
				int num=shark[0];
				int x=shark[1];
				int y=shark[2];
				int dir=shark[3];
//				System.out.println(num+" "+x+" "+y+" "+dir);
				if(map[x][y][0]!=0&&map[x][y][1]==k&&map[x][y][0]<num)//큰상어가 차지하고있음
					continue;
				map[x][y][0]=num;
				map[x][y][1]=k;
				map[x][y][2]=dir;
				
			}

			time++;
		}
		if(time>1000)
			System.out.println(-1);
		else
			System.out.println(time);

	}

}
