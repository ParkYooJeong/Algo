class str_compression {
	public int solution(String s) {
		int answer = s.length();
		int n = s.length();

		for (int i = 1; i <= n / 2; ++i) {// 자르는 단위
			int pos = 0; // position
			int len = s.length();

			for (; pos + i <= s.length();) {
				String unit = s.substring(pos, pos + i);
				pos += i;

				int cnt = 0;
				for (; pos + i <= s.length();) {
					if (unit.equals(s.substring(pos, pos + i))) {
						++cnt;
						pos += i;
					} else {
						break;
					}
				}

				if (cnt > 0) {
					len -= i * cnt;

					if (cnt < 9)
						len += 1;
					else if (cnt < 99)
						len += 2;
					else if (cnt < 999)
						len += 3;
					else
						len += 4;
				}
			}
			answer = Math.min(answer, len);

		}
		return answer;
	}
}
