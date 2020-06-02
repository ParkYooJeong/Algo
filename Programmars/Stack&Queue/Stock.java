
import java.util.*;

class Stock {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		st.push(0);

		for (i = 1; i < prices.length; i++) {
			while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
				int index = st.pop();
				answer[index] = i - index;
			}
			st.push(i);
		}
		i--;
		while (!st.isEmpty()) {
			int index = st.pop();
			answer[index] = i - index;
		}
		return answer;
	}
}