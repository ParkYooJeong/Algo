class The_Way_To_School {
	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;

		int[][] map = new int[n + 1][m + 1];

		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1]][puddles[i][0]] = -1;
		}

		map[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == -1) {
					continue;
				}
				if (map[i][j - 1] >= 0 && map[i][j] >= 0) {// ¿ŞÂÊ¿¡ ¿õµ¢ÀÌ ¾øÀ½
					map[i][j] += map[i][j - 1] % 1000000007;
				}
				if (map[i - 1][j] >= 0 && map[i][j] >= 0) {// À­ÂÊ¿¡ ¿õµ¢ÀÌ¾øÀ½
					map[i][j] += map[i - 1][j] % 1000000007;
				}
			}
		}
		answer = map[n][m] % 1000000007;
		return answer;
	}
}