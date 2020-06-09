import java.util.*;
import java.io.*;


public class Beak_1946 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++) {
			int peo=Integer.parseInt(br.readLine());			
			int[][] arr=new int[peo][2];
			
			for(int j=0;j<peo;j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0]=Integer.parseInt(st.nextToken());
				arr[j][1]=Integer.parseInt(st.nextToken());				
			}
			Arrays.sort(arr,new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {					
					return a[0]-b[0];
				}
			});
			int prev=arr[0][1];
			for(int k=1;k<arr.length;k++) {
				if(prev<arr[k][1]) 
					peo--;		
				else prev=arr[k][1];			
			}
			System.out.println(peo);
		}

	}
}