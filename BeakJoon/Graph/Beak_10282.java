
import java.io.IOException;
import java.util.*;

class Pair implements Comparable<Pair> {
	int c;
	int t;

	public Pair(int c, int t) {
		this.c = c;
		this.t = t;
	}

	@Override
	public int compareTo(Pair p) {
		return this.t - p.t;
	}
}

class Beak_10282 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();

		for (int i = 0; i < test; i++) {
			int com = sc.nextInt();
			int line = sc.nextInt();
			int hacking = sc.nextInt()-1;

			ArrayList<Pair>[] arr = new ArrayList[com];

			int[] dist = new int[com];

			for (int j = 0; j < com; j++)
				arr[j] = new ArrayList<>();// 리스트 활성화

			for (int j = 0; j < line; j++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				int cost = sc.nextInt();

				arr[to].add(new Pair(from, cost));
			}
			Arrays.fill(dist, Integer.MAX_VALUE);

			int time = 0;
			int number = 1;

			dist[hacking] = 0;
			q.add(new Pair(hacking, 0));

			while (!q.isEmpty()) {// 다이제스트라
				Pair p = q.poll();
				int c = p.c;
				int t = p.t;

				if (dist[c] < t)
					continue;

				for (Pair s : arr[c]) {
					int next = s.c;
					int next_d = t + s.t;
					if (next_d < dist[next]) {
						if (dist[next] == Integer.MAX_VALUE)
							number++;
						dist[next] = next_d;
						q.add(new Pair(next, next_d));
					}
				}
			}

			for (int k : dist) {
				if (time < k && k != Integer.MAX_VALUE)
					time = k;
			}
			System.out.println(number + " " + time);

		}

	}
}
