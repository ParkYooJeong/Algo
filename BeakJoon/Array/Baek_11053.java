import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Baek_11053 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		int d[] = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		int answer=0;
		d[0]=1;
		
		for (int i = 1; i < size; i++) {
			d[i]=1;
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]&&d[i]<=d[j])
					d[i]=d[j]+1;				
			}
		} 
		for(int i:d) {
			if(answer<i)
				answer=i;
		}
		System.out.println(answer);
	}
}