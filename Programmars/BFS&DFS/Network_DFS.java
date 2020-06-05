class Network_DFS {
	public boolean visit[];
	public int link[][];
	public int count = 0;

	public int solution(int n, int[][] computers) {
		visit = new boolean[n];
		link = computers;
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				count++;
				dfs(i);
			}
		}
		return count;
	}

	public void dfs(int i) {
		if (!visit[i]) {
			visit[i] = true;

			for (int j = 0; j < visit.length; j++) {
				if (link[i][j] == 1)
					dfs(j);
			}
		}
	}
}