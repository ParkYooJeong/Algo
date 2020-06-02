import java.util.*;

class Budget {
	public int solution(int[] budgets, int M) {
		Arrays.sort(budgets);

		int left = 0;
		int right = budgets[budgets.length - 1];

		while (left <= right) {
			int mid = (left + right) / 2;
			int total = 0;

			for (int i = 0; i < budgets.length; i++) {
				total += budgets[i] < mid ? budgets[i] : mid;
			}

			if (total <= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return right;

	}

	public static void main(String[] args) {
		Budget s = new Budget();
		int[] arr = { 120, 110, 140, 150 };
		int answer = s.solution(arr, 485);
		System.out.println(answer);
	}
}