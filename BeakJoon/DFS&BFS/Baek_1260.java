import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Baek_1260 {
	static boolean[][] connect;

	public static void dfs(boolean visit[], int start) {
		visit[start] = true;
		System.out.print(start);
		for (int i = 1; i < visit.length; i++) {
			if ((connect[i][start] || connect[start][i]) && !visit[i]) {
				System.out.print(" ");
				dfs(visit, i);
			}
		}
	}

	public static void bfs(boolean visit[], int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visit[start] = true;
		queue.add(start);
		System.out.print(start);

		while (!queue.isEmpty()) {
			int vertex = queue.poll();

			for (int i = 1; i < visit.length; i++) {
				if ((connect[i][vertex] || connect[vertex][i]) && !visit[i]) {
					System.out.print(" ");
					queue.add(i);
					visit[i] = true;
					System.out.print(i);
				}
			}
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int vertex_number = Integer.parseInt(st.nextToken());
		int line_number = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		connect = new boolean[vertex_number + 1][vertex_number + 1];
		boolean[] visit = new boolean[vertex_number + 1];
		boolean[] visit_bfs = new boolean[vertex_number + 1];

		for (int i = 0; i < line_number; i++) {
			int linel;
			int liner;
			st = new StringTokenizer(br.readLine(), " ");

			linel = Integer.parseInt(st.nextToken());
			liner = Integer.parseInt(st.nextToken());
			connect[linel][liner] = true;

		}
		dfs(visit, start);
		System.out.println("");
		bfs(visit_bfs, start);
	}
}