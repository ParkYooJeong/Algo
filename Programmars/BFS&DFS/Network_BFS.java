import java.util.*;

class Network_BFS {
	public int solution(int n, int[][] computers) {
		int count = 0;
		boolean visit[] = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		
		for (int j = 0; j < n; j++) {
			if (!visit[j]) {
				q.add(j);
				count++;

				while (!q.isEmpty()) {
					int start = q.poll();
					visit[start] = true;

					for (int i = 0; i < n; i++) {
						if (!visit[i] && computers[start][i] == 1) {
							q.add(i);
						}
					}
				}
			}
		}
		return count;
	}

}