package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_안전영역_2468 {
	
	
	static int arr[][];
	static int N;
	static int res=0;
	static boolean visit[][];
	static int dr[] = {-1,1,0,0}; 
	static int dc[] = {0,0,-1,1}; 
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		//높이는 1이상 100이하
		//안전지대가 0이될때까지만 확인
		//비가 오지 않을때 안전지대는 1개인데. 기본이 1에서 시작하나?
		
		int h=0;//비의 높이,비가 오지 않는경우도 있다.
		while(true) {
			for(int i=0;i<N;i++) {
				Arrays.fill(visit[i],false);
			}
			
			que.clear();
			
			int count=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visit[i][j] && (arr[i][j] > h)) {
						que.offer(new int[] {i,j});
						visit[i][j]=true;
						bfs(h);
						count++;//안전지대의 수 반환
					}

				}
			}
			
			
			if(count==0) break;
			res = res > count ? res : count ;
			h++;
		}
		System.out.println(res);
		
	
	}
	static Queue<int[]> que = new ArrayDeque<>();
	static boolean bfs(int h) {
		if(que.isEmpty()) return false;

		int []now =que.poll();
		int r = now[0];
		int c = now[1];


		for(int k=0;k<4;k++) {
			int row = r+dr[k];
			int col = c+dc[k];

			if(row>=0 && row < N && col>=0 && col < N && !visit[row][col] && arr[row][col] > h) {
				que.offer(new int[] {row,col});
				visit[row][col] = true;
			}
		}
		return bfs(h);

	}


}
