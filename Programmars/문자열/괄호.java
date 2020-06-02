class °ýÈ£ {
	public String solution(String s) {
		String answer = "";
		boolean check = true;
		boolean end = true;
		int count = 0;
		int i;
		if (s.equals(""))
			return answer += "";
		for (i = 0; i < s.length() && end; i++) {
			count += s.charAt(i) == '(' ? +1 : -1;
			if (count < 0)
				check = false;
			if (count == 0) {
				end = false;
			}
		}
		if (check) {
			answer += s.substring(0, i);
			answer += solution(s.substring(i));
		} else {
			answer += "(";
			answer += solution(s.substring(i));
			answer += ")";
			String uni = "";
			for (int j = 1; j < i - 1; j++)
				uni += s.charAt(j) == '(' ? ")" : "(";
			answer += solution(uni);

		}
		return answer;
	}
}