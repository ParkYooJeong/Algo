import java.util.*;

public class Printer {
	public int solution(int[] priorities, int location) {
		Queue<Integer> que = new LinkedList<Integer>();
		int num = 0;
		for (int i : priorities) {
			que.add(i);
		}
		for (int a = 0; a < priorities.length - 1; a++) {
			for (int i = 0; i < priorities.length - 1 - a; i++) {
				if (priorities[i] < priorities[i + 1]) {
					int tmp;
					tmp = priorities[i];
					priorities[i] = priorities[i + 1];
					priorities[i + 1] = tmp;
				}
			}
		}

		while (true) {
			int size = que.size();
			if (location < 0)
				location = size - 1;

			if (priorities[num] == que.peek()) {
				if (location == 0)
					break;
				que.poll();
				num++;
				location--;
			} else {
				que.add(que.poll());
				location--;
			}
		}
		return num + 1;

	}

}
