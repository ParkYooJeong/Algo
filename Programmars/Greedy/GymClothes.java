import java.util.*;

class GymClothes {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		int[] stu = new int[n];

		for (int i : reserve)
			stu[i - 1] = 1;
		for (int i : lost)
			stu[i - 1] -= 1;

		for (int i = 0; i < stu.length; i++) {
			if (stu[i] == -1) {
				if (i != 0 && stu[i - 1] == 1)
					stu[i - 1] = 0;
				else if (i != stu.length - 1 && stu[i + 1] == 1)
					stu[i + 1] = 0;
				else
					answer--;
			}
		}

		return answer;
	}
}