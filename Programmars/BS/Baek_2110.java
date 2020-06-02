
import java.io.*;
import java.util.*;

public class Baek_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(sc.readLine());
		int home = Integer.parseInt(st.nextToken());
		int wifi = Integer.parseInt(st.nextToken());
		int[] arr = new int[home];

		for (int i = 0; i < home; i++) {
			arr[i] = Integer.parseInt(sc.readLine());
		}
		Arrays.sort(arr);
		int left = 1;//�Ÿ� �ּҴ� 1�μ���
		int right = arr[arr.length - 1] - arr[0];//�Ÿ� �ִ밪
		int max=0;
		
		while (left <= right) {
			int mid=(left+right)/2;
			int prev=arr[0];//ù��° ���� �����⼳ġ
			int count=1;
			
			for(int i=1;i<arr.length;i++) {
				if(mid<=arr[i]-prev) {//�Ÿ����� MID ���� ũ�� ������ ��ġ����
					count++;
					prev=arr[i];
				}
			}
			if(count>=wifi) {//ī��Ʈ���� �����⺸�� ���ų� ������ �ִ밪 ���Ҽ� �ֵ�!
				if(max<mid)// Ǯ���� IF���� ��� �ɰͰ���.->������ �� �ִ밪 ��������
					max=mid;		

				left=mid+1;
			}
			else {
				right=mid-1;
			}

		}
		System.out.println(max);

	}

}
