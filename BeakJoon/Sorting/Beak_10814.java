import java.util.*;

public class Beak_10814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		String arr[][] = new String[num][2];

		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
		}

		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String a[], String b[]) {
				if (!a[0].equals(b[0])) {
					return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
				}
				return 0;
			}
		});
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}

}