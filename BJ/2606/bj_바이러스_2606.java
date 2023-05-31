package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_바이러스_2606 {

	//1.BFS
	//1.1인접리스트
	static int K,N;
	static int count;
	static Queue<Integer> que = new ArrayDeque<Integer>();
	static boolean[]  visit;
	static List<List<Integer>> map = new ArrayList<>();
	public static void main(String[] args) throws Exception  {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {//dummy
			map.add(new ArrayList<Integer>());//N개의 정점이므로 N개 추가한다.
		}
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			//양방향
			
			map.get(start).add(end);
			map.get(end).add(start);
		}
		
		
		//bfs(1);
		dfs(1);
		
		System.out.println(count-1);
		
	}
	static void dfs(int n) {
		visit[n] = true;
		
		count++;
		map.get(n).forEach(a ->{
			if(!visit[a]) dfs(a);
		});
//		friends[num].list.forEach((n) ->{
//			if((visit & 1<<n) == 0) dfs(n,cnt+1,visit|1<<n);
//		});
		
	}
	static void bfs(int n) {
		visit[n] =true;
		que.offer(n);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			count++;
			//System.out.println(now);
			//now번째 리스트의 원소들을 탐색
			List<Integer> list = map.get(now);
			for(int a : list) {
				if(visit[a]) continue;
				que.offer(a);
				visit[a] =true;//다 넣으면 넘어간다.				
			}
		
			
		}
		
		
		
	}

}
