package basic.wk3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Test {

	static boolean visit[];
	static List<List<Integer>> adjList = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		adjList.get(1).add(2);
		adjList.get(1).add(2);
		
		adjList.get(2).add(3);
		adjList.get(2).add(4);
		
		adjList.get(3).add(4);
		adjList.get(4).add(3);
		
		//adjList을 입력
		visit = new boolean[5];
		bfs(1);
		System.out.println();
		System.out.println(Arrays.toString(visit));
		
		visit = new boolean[5];
		dfs(1);
		System.out.println();
		System.out.println(Arrays.toString(visit));

	}
	static void bfs(int n) {
		Queue<Integer> que = new ArrayDeque<>();
		visit[n] = true;
		que.offer(n);
		
		while(!que.isEmpty()) {
			
			int v = que.poll();
			System.out.print(v+"-> ");
			List<Integer> list = adjList.get(v); //현재 정점과 인접한것들의 리스트 반환
			
		
			for(int i:list) {
				if(visit[i]) continue;
				que.offer(i);
				visit[i] =true; // 여기서 또 필요
			}
			
		}
		
	}
	static void dfs(int n) {
		visit[n] = true;
		System.out.print(n+ "->");
		
		List<Integer> list = adjList.get(n); //현재 노드에서 갈수 있는 것들을 반환한다.
		for(int i: list) {
			if(visit[i]) continue;
			dfs(i);
		}
		
	}

}
