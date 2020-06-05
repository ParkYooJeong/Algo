class Top_Array {// 옛날에 풀어둔것 stack으로 풀지않았당
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		for (int i = heights.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[j] > heights[i]) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}
}
