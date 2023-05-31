package my.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//라이브 강의 풀이
public class sw_보급로_1249 {
	static int N,map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <=T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					map[i][j] = ch[j] -'0';
				}
				
			}
			System.out.println("#"+test+" "+dijkstra());
		}

	}
	
	private static int dijkstra() {
		final int INF = Integer.MAX_VALUE;
		int[][] minTime = new int[N][N];
		boolean[][] visited = new boolean[N][N]; // 테스트케이스에 따라 초기화 해주지 않아도 된다.
		PriorityQueue<int []> que = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2],o2[2]);
			}
			
		}); //r,c,비용
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] =INF;
			}
		}
		
		int[] cur =null;
		int r,c,minCost;
		minTime[0][0]=0;//시작정점까지의 비용
		que.offer(new int[] {0,0,minTime[0][0]});
		while(true) {
			//step 1
			cur = que.poll();
			r = cur[0];
			c = cur[1];
			minCost = cur[2];
			
			visited[r][c] = true; //여기서 방문체크
			if(r==N-1 && c==N-1) {return minCost;}
			//step 2
			int nr=0;
			int nc=0;
			for (int d = 0; d < 4; d++) {
				nr = r+dr[d];
				nc = c+dc[d];
				
				//범위내에 있고, 최단거리를 수정하는 값만 큐에 다시 넣어준다.
				// 최단거리인 해당위치를 시작으로 다시 탐색하기위해서
				// 어차피 이전경로 값을 수정하지 못한다면 
				if(nr >=0 && nr <N &&nc >=0 && nc <N && !visited[nr][nc] && minTime[nr][nc] > minCost+ map[nr][nc] ){
					minTime[nr][nc] = minCost+ map[nr][nc]; // 여기서 최단거리를 수정
					que.offer(new int[] {nr,nc,minTime[nr][nc]});
				} 
				
			}
		}

	}

}
