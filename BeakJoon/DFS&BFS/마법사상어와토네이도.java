package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이도 {
	static int[][] d = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };// 왼아오위
	static double[][][] move = new double[4][5][5];// 왼쪽move
	static int[][] map;
	static int N,s,e;
	public static void main(String[] args) throws NumberFormatException, IOException {
		move[0] = new double[][] {{0,0,0.02,0,0},{0,0.1,0.07,0.01,0},{0.05,0,0,0,0},{0,0.1,0.07,0.01,0},{0,0,0.02,0,0}};

		for (int i = 1; i < 4; i++) {
			rotaion(i);
		}
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		map=new int[N+10][N+10];
		s=5;
		e=5+N;

		for (int i = s; i < e; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = s; j < e; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int x=(s+e)/2;
		int y=(s+e)/2;
		int size=1;
		int num=0;
		
		loop: while(true) {
			for (int k = 0; k < 4; k++) {
				num++;
				for (int i = 1; i <= size; i++) {
					int dx=x+d[k][0];
					int dy=y+d[k][1];
					
					if(dx<s||dy<s||dx>=e||dy>=e)
						break loop;
					soil(dx,dy,map[dx][dy],k);
					x=dx;
					y=dy;
				}
				if(num==2) {
					num=0;
					size++;
				}
			}
		}
		
		int answer=0;
		
		for (int i = 0; i < N+10; i++) {
			for (int j = 0; j < N+10; j++) {
				if(i<s||j<s||i>=e||j>=e)
					answer+=map[i][j];
			}
		}
		System.out.println(answer);

	}
	private static void soil(int x, int y, int amount, int k) {
		int alpha=amount;
		map[x][y]=0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(move[k][i][j]==0)
					continue;
				int num=(int)(amount*move[k][i][j]);
				map[x+i-2][y+j-2]+=num;
				alpha-=num;
			}
		}
		map[x+d[k][0]][y+d[k][1]]+=alpha;
	}
	//반시계 90도 회전
	private static void rotaion(int i) {
		double[][] copy=new double[5][5];
		
		for (int j = 0; j < copy.length; j++) {
			copy[j]=move[i-1][j].clone();
		}
		
		for (int n = 0; n < 5; n++) {
			for (int m = 0; m < 5; m++) {
				move[i][n][m]=copy[m][4-n];
			}
		}
	}
}
