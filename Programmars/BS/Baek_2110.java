
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
		int left = 1;//거리 최소는 1로설정
		int right = arr[arr.length - 1] - arr[0];//거리 최대값
		int max=0;
		
		while (left <= right) {
			int mid=(left+right)/2;
			int prev=arr[0];//첫번째 집에 공유기설치
			int count=1;
			
			for(int i=1;i<arr.length;i++) {
				if(mid<=arr[i]-prev) {//거리값이 MID 보다 크면 공유기 설치가능
					count++;
					prev=arr[i];
				}
			}
			if(count>=wifi) {//카운트값이 공유기보다 많거나 같으면 최대값 구할수 있듬!
				if(max<mid)// 풀고나니 IF문은 없어도 될것같다.->끝났을 때 최대값 들어와있음
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
