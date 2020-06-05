import java.util.*;

class Top_Stack {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < heights.length; i++) {
			st.push(heights[i]);
		}
		
		int index = heights.length - 1;
		
		while (!st.isEmpty()) {
			int height = st.pop();

			for (int i = index - 1; i >= 0; i--) {
				if (heights[i] > height) {
					answer[index] = i + 1;
					break;
				}
			}
			index--;
		}

		return answer;
	}
}