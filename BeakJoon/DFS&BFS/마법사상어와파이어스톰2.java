package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마법사상어와파이어스톰2 {
	static int N,Q;
	static int[][] d= {{1,0},{0,1},{-1,0},{0,-1}};
	static int mass=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		
		N=(int)Math.pow(2, n);
		int[][] map=new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			 st=new StringTokenizer(br.readLine());
			 for (int j = 0; j < map.length; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for (int t = 0; t < Q; t++) {
			int L=Integer.parseInt(st.nextToken());
			int size=(int)Math.pow(2, L);
			//회전
			for (int i = 0; i < map.length; i+=size) {
				for (int j = 0; j < map.length; j+=size) {
					rotation(i,j,size,map);
				}
			}
			//인접한 애들 얼음카운트
			int[][] map_copy=new int[N][N];
			for (int i = 0; i < map.length; i++) {
				map_copy[i]=map[i].clone();
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map_copy[i][j]>0&&ice(i,j,map_copy)<3) {
						map[i][j]--;
					}
				}
			}
		}
		//모든 얼음 더하기
		int sum=0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
					sum+=map[i][j];
			}
		}
		boolean[][] visit=new boolean[N][N];
		int max=0;
		
		//덩어리 얼음갯수 구하기
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(!visit[i][j]&&map[i][j]>0) {
					mass=1;
					visit[i][j]=true;
					dfs(i,j,map,visit);
					if(max<mass)
						max=mass;
				}
			}
		}
		System.out.println(sum);
		System.out.println(max);
		
	}

	private static void dfs(int x, int y,int[][] map, boolean[][] visit) {
		for (int k = 0; k < 4; k++) {
			int dx=x+d[k][0];
			int dy=y+d[k][1];
			
			if(dx<0||dy<0||dx>=N||dy>=N||visit[dx][dy])
				continue;
			if(map[dx][dy]>0) {
				mass++;
				visit[dx][dy]=true;
				dfs(dx,dy,map,visit);
			}
		}
	}

	private static int ice(int x, int y, int[][] map) {
		int count=0;
		
		for (int k = 0; k < 4; k++) {
			int dx=x+d[k][0];
			int dy=y+d[k][1];
			
			if(dx<0||dy<0||dx>=N||dy>=N)
				continue;
			if(map[dx][dy]>0)
				count++;
		}
		return count;
	}

	private static void rotation(int x, int y, int size, int[][] map) {
		int[][] temp=new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp[i][j]=map[x+i][y+j];
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[x+i][y+j]=temp[size-j-1][i];
			}
		}
	}
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
}
