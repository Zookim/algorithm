package my.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class sw_보급로_1249 {
	// 최단 시간 -> 모든 경우의 수 확인 ??
	// 각 위치로 오기까지의 경로 중 최단 경로
	// 인접하고 있으면서, -1(미정) 인 값중에서 가장작은 값 + 자신의 값
	
	//값을 수정해 줄때 DFS여야한다.
	
	static class Loc{
		int r;
		int c;
		int w;
		public Loc(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
	}
	static int arr[][];
	static int ans[][];
	static boolean visit[][];
	static int dr[] = {-1,1,0,0};//상,좌 ,대각
	static int dc[] = {0,0,-1,1};//상,좌,대각
	static int N;
	final static int INF = Integer.MAX_VALUE;
	static PriorityQueue<Loc> que = new PriorityQueue<>((e1,e2)->e1.w-e2.w);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case <= T; test_case++) {
            que.clear();
			N = Integer.parseInt(br.readLine());
			arr = new int [N][N];
			ans = new int [N][N];
			visit = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				Arrays.fill(ans[i], INF);
			}
			//
			
			
			for(int i=0;i<N;i++) {
				String [] temp = br.readLine().split("");
				for(int j=0;j<N;j++) {
					arr[i][j] =Integer.parseInt(temp[j]); 
					
				}
			}

			dijkstra();
			//print();
			System.out.println("#"+test_case+" "+ans[N-1][N-1]);

		}
		


	}

	//
	static void dijkstra() {
		que.offer(new Loc(0,0,0));
		ans[0][0] =0;
		
		while(!que.isEmpty()) {
			Loc now = que.poll();
			int nowr=now.r;
			int nowc=now.c;
			int noww=now.w;
			
			if(visit[nowr][nowc]) continue;
			visit[nowr][nowc] = true;
			
			if(nowr == N-1 && nowc == N-1) break;//얘가 다른애랑 얼마나 인접하는지 볼 필요없다.
			
			for(int k=0;k<4;k++) { // 어느 것을 참조할지 결정
				int row = nowr+dr[k];
				int col = nowc+dc[k];
				if(row >=0 && row <N && col >= 0 && col <N && ans[row][col] > arr[nowr][nowc] + noww) {
					ans[row][col] = arr[nowr][nowc] + noww;
					que.offer(new Loc(row,col,ans[row][col]));
					
				}
			
				
			}
			
			//print();
		}

	}
	
	static void print() {
		for(int [] a: ans) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

}
