import java.util.*;

class Pair {
	public int solution(String s) {
		if (s.length() % 2 != 0)
			return 0;
		Stack<Character> st = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (!st.isEmpty() && st.peek() == c)
				st.pop();
			else
				st.push(c);
		}
		if (st.isEmpty())
			return 1;
		return 0;
	}
}