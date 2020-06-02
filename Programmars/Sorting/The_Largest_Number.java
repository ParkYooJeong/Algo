import java.util.*;

class The_Largest_Number {
	public String solution(int[] numbers) {
		String answer = "";
		String[] num = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			num[i] = numbers[i] + "";

		Arrays.sort(num, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});
		for (String i : num)
			answer += i;
		if (answer.charAt(0) == '0')
			return "0";
		return answer;
	}
}
