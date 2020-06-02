import java.util.*;

class Boat {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int i = 0;

		for (int j = people.length - 1; i <= j; j--) {
			if (people[j] + people[i] > limit)// 처음과 마지막부터 더함
				answer++;

			else {
				answer++;
				i++;
			}
		}

		return answer;
	}
}