package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;




public class bj_DFS와BFS_1260 {
	//정점의 번호가 작은것먼저
	//간선은 양방향
	static StringBuilder sb;
	static int N,M,V;
	static List<List<Integer>> arr = new ArrayList<List<Integer>>(); //정렬?
	static boolean visit[];
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		
		for(int i=0;i<=N;i++) {
			arr.add(new ArrayList<Integer>()); //그냥 정점의 수만큼 넣어준다.
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			//양방향이므로 양쪽에 넣어준다.
			arr.get(start).add(end);
			arr.get(end).add(start);
			
		}
		
	
		
		sb = new StringBuilder();
		visit = new boolean[N+1]; //dummy
		dfs(V);
		System.out.println(sb);
		
		sb = new StringBuilder();
		visit = new boolean[N+1]; //dummy
		bfs(V);
		System.out.println(sb);
	}

	static void dfs(int n) {
		visit[n] = true;
		
		sb.append(n).append(" ");
		
		
		List<Integer> list =  arr.get(n);
		list.sort((n1,n2) -> n1- n2);
		for(int a : list) {
			if(visit[a]) continue;
			dfs(a);

		}
		
		

	}
	static void bfs(int n) {
		Queue<Integer> pqueue = new ArrayDeque<>();
		pqueue.offer(n);
		visit[n] = true;
		
		while(!pqueue.isEmpty()) {
			int now = pqueue.poll();
			sb.append(now).append(" ");
			
			List<Integer> list =  arr.get(now);
			list.sort((n1,n2) -> n1- n2);
			for(int a : list) {
				if(visit[a]) continue;
				pqueue.offer(a);
				visit[a] = true;
			}
			
		}
		
	}

}
