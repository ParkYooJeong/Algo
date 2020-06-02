import java.util.*;

public class Beak_15649 {
	static int num2;
	static int num;

	static void ans(int arr[], boolean check[], int count) {

		if (count == num2) {
			for (int i = 0; i < num2 - 1; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.print(arr[num2 - 1] + "\n");
			return;
		}

		for (int i = 0; i < num; i++) {
			if (check[i])
				continue;
			check[i] = true;
			arr[count] = i + 1;
			ans(arr, check, count + 1);
			check[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		num2 = sc.nextInt();
		boolean check[] = new boolean[num];
		int arr[] = new int[num2];
		ans(arr, check, 0);

	}

}
