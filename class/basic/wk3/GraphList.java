package basic.wk3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class GraphList {

	//정점 1,2,3,4
	//배열은 5개, 0은 dummy
	//1 ->2 ,4
	//2 ->3 ,4
	//3 ->2
	//4 ->3
	//필요에 따라 Integer가 아닌 정의한 클래스 사용
	static List<List<Integer>> adjList = new ArrayList<List<Integer>>();


	static boolean[] visit;
	public static void main(String[] args) {
		
		for(int i=0;i<5;i++) {
			adjList.add(new ArrayList<Integer>()); // 각 기본 정점에 대한 인접 정점을 입력해주기위해, 
		}                                          //미리 리스트를 준비한다.
		 //직접 입력값을 넣어준다.
		//인접한 정점중 갈 수 있는 곳만 관리한다 , 배열에 비해 메모리 절약 가능
		adjList.get(1).add(2);
		adjList.get(1).add(2);
		
		adjList.get(2).add(3);
		adjList.get(2).add(4);
		
		adjList.get(3).add(4);
		adjList.get(4).add(3);
		
		
		
		
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
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		visit[n] = true; //현재 이미 방문하는 중
		
		while(! queue.isEmpty()) {
			int v = queue.poll();
			
			System.out.print(v+"->");
			
			List<Integer> list = adjList.get(v);
			for (int i: list) {
				if(visit[i]) continue; //이미 방문했었는지만 확인하면된다.
				queue.offer(i);
				visit[i] =true;
			}
		}
	}

	static void dfs(int n) {
		
		visit[n] = true;
		
		System.out.print(n+"->");
		
		List<Integer> list = adjList.get(n);
		for (int i: list) {
			if(visit[i]) continue; //이미 방문했었는지만 확인하면된다.
			dfs(i);

		}
		
	
	}
	
	
	
}
