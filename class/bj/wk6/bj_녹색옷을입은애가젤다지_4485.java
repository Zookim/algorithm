package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_녹색옷을입은애가젤다지_4485 {

	//최소비용으로 00에서 NN으로 이동
	static int N;
	static int arr[][];
	static int ans;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int weight[][];
	static boolean visit[][];
	static class Edge{
		int w;
		int r;
		int c;
		public Edge(int r, int c, int w) {
			super();
			this.w = w;
			this.r = r;
			this.c = c;
		}
		
		
	}
	static int INF = Integer.MAX_VALUE;
	static PriorityQueue<Edge> que = new PriorityQueue<>((e1,e2) -> e1.w-e2.w);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		N = Integer.parseInt(br.readLine());
		while(N != 0) {
			cnt++;
			weight = new int[N][N];
			
			for(int i=0;i<N;i++) {
				Arrays.fill(weight[i],INF );
			}
			
			visit =  new boolean [N][N];
			arr = new int [N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			weight[0][0] = arr[0][0]; 
			dijkstra();
			
			
			//System.out.println(weight[N-1][N-1]);
			sb.append("Problem ").append(cnt).append(": ").append(weight[N-1][N-1]).append("\n");
			
			//다음
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
		
	}
	//현재 노드에서 다음노드로 가는 방법중 최소를 찾는다.
	// 최단으로 등록하고 그 노드에서다음노드로 가는 것을 찾는다
	//최단인것을 찾으면 수정하고
	// 우선순위 큐
			
	static void dijkstra(){
		que.offer(new Edge(0,0,arr[0][0]));
		
		while( !que.isEmpty() ) {
			Edge now = que.poll();
			int r = now.r;
			int c = now.c;
			
			
			if(r==N && c==N) {return;}
			
			//System.out.println("r "+r+" c "+c + " w "+now.w);
			if(visit[r][c]) continue;
			visit[r][c] = true;
			
			
			
			for(int i=0;i<4;i++) {
				int row = r+dr[i];
				int col = c+dc[i];
				if(row >=0 && row <N && col >=0 && col < N && weight[row][col] > weight[r][c] + arr[row][col]) { //범위 내에 있고 이전 보다 비용이 더 작으면
					weight[row][col] =  weight[r][c] + arr[row][col];
					arr[row][col] = weight[row][col];
					que.offer(new Edge(row,col,arr[row][col]));
				}
			}
			
			
		}
		
		
	}

}
