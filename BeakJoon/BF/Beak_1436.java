import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(sc.readLine());
		int count = 0;

		for (int i = 666; i < 9999999; i++) {
			int n = i;

			while (n != 0) {
				if (n % 1000 == 666) {
					count++;
					break;
				}
				n /= 10;
			}

			if (count == num) {
				System.out.println(i);
				break;
			}

		}

	}
}