
import java.util.*;

public class Beak_11651 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[][] = new int[num][2];

		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();

		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int arr[], int arr2[]) {
				if (arr[1] == arr2[1]) {
					return Integer.compare(arr[0], arr2[0]);
				} else
					return Integer.compare(arr[1], arr2[1]);
			}
		});

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}

}