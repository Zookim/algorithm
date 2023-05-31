package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
//while로 풀이
public class bj_미로탐색_2178_2 {

	static boolean visit[][];
	static int arr[][];
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int M,N,C;
	static Queue<int[]> que = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N][M];
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String [] str = br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				
			}
		}
	

		bfs(0,0);//시작점
		//print();
		System.out.println(arr[N-1][M-1]);

		
	}
	static void print() {
		for(int [] a: arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	//1while 
	
	static void bfs(int r,int c) {
		visit[r][c] =true;
		que.offer(new int[] {r,c});
		
		while(! que.isEmpty()) {
			//int count++;
			//다음경로 찾기
			int now[] = que.poll();	
			int nr= now[0];
			int nc = now[1];//
			for(int i=0;i<4;i++) {
				int col = nc+dc[i];
				int row = nr+dr[i];
				if(row >= 0 && row <N && col <M && col>=0 && !visit[row][col] && arr[row][col]==1) {
					que.offer(new int[] {row,col});
					visit[row][col] = true;
					arr[row][col]= arr[nr][nc]+1;
				}
			}
			
		}
		
		
	}

}
