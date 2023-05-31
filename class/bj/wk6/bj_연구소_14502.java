package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_연구소_14502 {
	static int N,M;
	static int arr[][];
	static boolean wall[];
	static List<Point> b = new ArrayList<>();
	
	static class Point{
		int r;int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static boolean visit[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int danger=0;
	static boolean visitlocal[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		wall = new boolean[N*M];
		visit = new boolean[N][M];
		visitlocal = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <M; j++) {
				int a =  Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				if(a != 0) {// 빈칸이 아니면
					visitlocal[i][j]=true;// 방문할수 없다.
					visit[i][j]=true;// 방문할수 없다.
					wall[i*M+j] = true;//벽을 놓을 수 없다/
					if(a==2) {
						
						b.add(new Point(i,j));
					}
				}
			}
		}
		//입력
		int maxs=0;
		
		//벽을 선택하는 경우
		for(int i=0;i<N*M-2;i++) {
			if(wall[i]) continue;
			arr[i/M][i%M]=1;
			for(int j=i+1;j<N*M-1;j++) {
				if(wall[j]) continue;
				arr[j/M][j%M]=1;
				for(int k=j+1;k<N*M;k++) {
					if(wall[k]) continue;
					arr[k/M][k%M]=1;
					
					//print();
					//System.out.println();
					
					
					//i,j,k위치에 벽이 있다.dfs로 해당 각 2를 모두 돌았을때, visit되지 않는 위치의합을 구한다.
					danger = -3;
					for(Point now : b) {

						dfs(now.r,now.c);
						

					}
					
					//printvisit();

					//방문 배열을 초기화한다.
					resetvisit();
					
					maxs = (maxs > danger) ? maxs : danger;
				
					
					
					arr[k/M][k%M]=0;
					
				}
				arr[j/M][j%M]=0;
			}
			arr[i/M][i%M]=0;
		}
		
		
		System.out.println(maxs);
		
		

	}
	static void printvisit() {
		for (boolean a[] : visitlocal) {
			System.out.println(Arrays.toString(a));
		}
	}
	static void print() {
		for (int a[] : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	static void resetvisit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visitlocal[i][j]) {danger++;} // 전염되지 않은 영역을 구한다.
				visitlocal[i][j] = visit[i][j];
			}
		}
	}
	
	static void dfs(int r, int c) {
		
		visitlocal[r][c] = true;
		
		
		for(int i=0;i<4;i++) {
			int row = r+dr[i];
			int col = c+dc[i];
			if(row >=0 && row <N && col >=0 && col < M && !visitlocal[row][col] && arr[row][col] == 0  ) { //범위를 넘지 않고 인접하다면 간다.
				
				dfs(row,col);
			}
			
		}
		
		
	}
	
	

}
