
import java.io.IOException;
import java.util.*;

class Que implements Comparable<Que> {
	int area;
	int distance;

	public Que(int area, int distance) {
		this.area = area;
		this.distance = distance;
	}

	@Override
	public int compareTo(Que p) {
		return this.distance - p.distance;
	}
}

class Beak_5719 {
	static int[] dist;
	static int[][] arr;
	static ArrayList<Integer>[] trace;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int area = 1;
		int road = 1;

		while (true) {
			area = sc.nextInt();
			road = sc.nextInt();
			
			if (area == 0 && road == 0)
				break;

			int start = sc.nextInt();
			int end = sc.nextInt();
			
			trace = new ArrayList[area];
			arr = new int[area][area];
			dist = new int[area];

			for (int j = 0; j < area; j++) {
				dist[j] = Integer.MAX_VALUE;
				trace[j] = new ArrayList<>();// 리스트 활성화
				Arrays.fill(arr[j], -1);
			}

			for (int j = 0; j < road; j++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				int cost = sc.nextInt();

				arr[from][to] = cost;
			}
			
			dijkstra(start, end);
			pointremove(end);

			for (int k = 0; k < area; k++) {
				if (k == start) {
					dist[k] = 0;
				} else {
					dist[k] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra(start, end);

			if (dist[end] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else
				System.out.println(dist[end]);

		}
	}

	static void dijkstra(int start, int end) {

		PriorityQueue<Que> q = new PriorityQueue<Que>();

		dist[start] = 0;
		q.add(new Que(start, 0));

		while (!q.isEmpty()) {// 다익스트라
			Que p = q.poll();
			int cur = p.area;
			int distance = p.distance;

			if (dist[cur] < distance)
				continue;

			for (int i = 0; i < arr.length; i++) {
				int next_d = distance + arr[cur][i];
				if (arr[cur][i] != -1 && next_d <= dist[i]) {
					dist[i] = next_d;
					q.add(new Que(i, next_d));
					trace[i].add(cur);
				}
			}
		}
	}

	static void pointremove(int end) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(end);

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < trace[temp].size(); i++) {
				int c = trace[temp].get(i);
				if (arr[c][temp] != -1 && dist[temp] == arr[c][temp] + dist[c]) {
					arr[c][temp] = -1;
					q.add(c);
				}
			}
		}
	}

}
