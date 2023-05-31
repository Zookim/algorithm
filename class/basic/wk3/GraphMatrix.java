package basic.wk3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class GraphMatrix {

	//정점 1,2,3,4
	//배열은 5개, 0은 dummy
	//1 ->2 ,4
	//2 ->4
	//3 ->2
	//4 ->3
	
	
	static boolean[][] matrix = {
			//dummy  1     2     3     4
			{false,false,false,false,false}, //dummy
			{false,false,true,false,true}, //1
			{false,false,false,false,true}, //2
			{false,false,true,false,false}, //3
			{false,false,false,true,false}  //4
	};
	static boolean[] visit;
	public static void main(String[] args) {
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
			
			//그래프에서 다음으로 갈 수 있는 놈을 찾는다.
			for (int i = 0; i <=4; i++) {
				if( !matrix[v][i] || visit[i]) continue;
				queue.offer(i);
				visit[i] =true;
			}
		}
	}

	static void dfs(int n) {
		
		visit[n] = true;
		
		System.out.print(n+"->");
		
		//그래프에서 다음으로 갈 수 있는 놈을 찾는다.
		for (int i = 0; i <=4; i++) {
			if( !matrix[n][i] || visit[i]) continue;
			dfs(i);
		
		}
	}
	
}
