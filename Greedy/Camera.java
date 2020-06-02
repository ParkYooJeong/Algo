import java.util.*;

class Camera {
	public int solution(int[][] routes) {
		int answer = 1;
		Arrays.sort(routes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		
		int end = routes[0][1];
		for (int i = 1; i < routes.length; i++) {
			if (end > routes[i][1]) {
				end = routes[i][1];
			} else if (end < routes[i][0]) {
				end = routes[i][1];
				answer++;
			}
		}
		return answer;
	}
}