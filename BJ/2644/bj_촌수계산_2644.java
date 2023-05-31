package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_촌수계산_2644 {

	//부보자식간의 관계만 있으므로 한번 이동하면 1촌이다.
	//bfs
	
	static int N,start,end;
	static int parents[];
	static boolean visit[];
	static boolean matrix[][];
	static int count= 0;
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		matrix = new boolean[N+1][N+1];
		
		//makeSet(N);
		st = new StringTokenizer(br.readLine());
		start =Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int num = Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			//무방향 그래프
			matrix[p][c] = true;
			matrix[c][p] = true;
			
			//union(p,c);
		}
//		System.out.println(Arrays.toString(parents));
//		if(findSet(start) != findSet(end)) {
//			System.out.println(-1);
//		}else {
//			find(start,end,findSet(start));
//			System.out.println(count);
//		}
		
		visit[start] = true;
		que.offer(-1);
		que.offer(start);
		if(bfs()) {
			System.out.println(count);
		}else {
			System.out.println(-1);
		}
		
		
		
	}
	static Queue<Integer> que = new ArrayDeque<>();
	static boolean bfs(){
		int now = que.poll();
		if(now == -1) {
			//-1이면 1촌이 끝났다.
			
			if(que.isEmpty()) {// 지금 빈것은 다음이 없다는것 , 처음이었다면 인접하지 않은것
				// 두번째였다면 1촌: -1 1 2  v -1 3  v -1
				return false;
			}
			count++;
			que.offer(-1);
			now = que.poll();
			
		}
		for(int i=1;i<=N;i++) {
			
			if(!visit[i] && matrix[now][i]) { //아직 방문전이고, now와 인접하고 있으면
				if(i == end) {return true;}
				que.offer(i);
				visit[i] = true;
			}
		}
		return bfs();
		
	}
	//
	
	static void find(int a,int b,int set) {
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(set);
		
		int m=2;
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i=1;i<=N;i++) {
				if(parents[i]==now) {
					
				}
			}
			
		}
		
		
		
	}
	static int findSet(int a) {
		if(parents[a] == a) {return a;}
		else {
			return findSet(parents[a]);
		}
	}
	static void union(int p,int c) {
		parents[c] = p;
		
	}
	static void makeSet(int n) {
		parents = new int [n+1];
		
		for(int i=1;i<=n;i++) {
			parents[i] = i;
		}
	}

}
