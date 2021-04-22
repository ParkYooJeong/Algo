package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모노미노도미노 {
	static int score;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] blue = new int[6][4];
		int[][] green = new int[6][4];

		for (int test = 0; test < N; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 블록내리기
			if (t == 1) {

				int blue_row = move(x, blue);
				blue[blue_row][x] = 1;

				int green_row = move(y, green);
				green[green_row][y] = 1;

			} else if (t == 2) {

				int blue_row = move(x, blue);
				blue[blue_row][x] = 1;
				blue[blue_row - 1][x] = 1;

				int green_row1 = move(y, green);
				int green_row2 = move(y + 1, green);
				int min = green_row1 < green_row2 ? green_row1 : green_row2;
				green[min][y] = 1;
				green[min][y + 1] = 1;

			} else if (t == 3) {

				int blue_row1 = move(x, blue);
				int blue_row2 = move(x + 1, blue);
				int min = blue_row1 < blue_row2 ? blue_row1 : blue_row2;
				blue[min][x] = 1;
				blue[min][x + 1] = 1;

				int green_row = move(y, green);
				green[green_row][y] = 1;
				green[green_row - 1][y] = 1;

			}

			// 행이 꽉차있는지 확인-> 행지우기 -> 행내리기
			for (int i = 0; i < 6; i++) {
				if (check(blue, i)) {
					down(blue, i);
					score++;
				}
				if (check(green, i)) {
					down(green, i);
					score++;
				}
			}

			// 01행에 블록 지움
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					if (blue[i][j] != 0) {
						down(blue, 5);
						break;
					}
				}
			}
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					if (green[i][j] != 0) {
						down(green, 5);
						break;
					}
				}
			}

		}
		// 남아있는 블록 갯수 세기
		int count = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				count += blue[i][j];
				count += green[i][j];
			}
		}
		System.out.println(score);
		System.out.println(count);
	}

	private static int move(int y, int[][] map) {
		int row = 0;

		for (; row < map.length; row++) {
			if (map[row][y] != 0)
				return row - 1;
		}

		return row - 1;
	}

	private static boolean check(int[][] map, int i) {
		for (int j = 0; j < 4; j++) {
			if (map[i][j] != 1)
				return false;
		}
		return true;
	}

	private static void down(int[][] map, int row) {
		int[][] new_map = new int[6][4];
		for (int i = 5; i > row; i--) {
			new_map[i] = map[i].clone();
		}

		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				new_map[i + 1][j] = map[i][j];
			}
		}
		for (int i = 0; i < 6; i++) {
			map[i] = new_map[i];
		}
	}
}
