import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
		int[] answer;
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] arr3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int s1 = 0;		int s2 = 0;		int s3 = 0;
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == arr1[i % arr1.length])
				s1++;
			if (answers[i] == arr2[i % arr2.length])
				s2++;
			if (answers[i] == arr3[i % arr3.length])
				s3++;
		}
		
		int max = Math.max(s1, Math.max(s2, s3));
		ArrayList<Integer> li = new ArrayList<>();

		if (max == s1) li.add(1);
		if (max == s2) li.add(2);
		if (max == s3) li.add(3);
		
		answer = new int[li.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = li.get(i);
		}
		return answer;
	}

}