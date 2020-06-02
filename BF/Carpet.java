class Carpet {
	public int[] solution(int brown, int yellow) {
		int sum = brown + yellow;
		int w = 3;	int h;

		for (h = 3; h < brown / 2; h++) {
			if (sum % h == 0) {
				w = sum / h;
				if (((h - 2) * (w - 2)) == yellow) {
					break;
				}
			}
		}
		int[] answer = { w, h };
		return answer;
	}
}