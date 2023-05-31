package basic.wk3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class GraphMatrix2 {

	//정점 1,2,3,4
	//배열은 5개, 0은 dummy
	//1 ->2 ,4
	//2 ->4
	//3 ->2
	//4 ->3
	
	static boolean visit[];
	static boolean[][] matrix = {
			//dummy  1     2     3     4     5    6    7       8
			{false,false,false,false,false,false,false,false,false}, //dummy
			{false,false,true,false,false,false,false,false,false}, //1
			{false,false,false,true,false,true,false,false,false}, //2
			{false,false,true,false,true,false,false,false,true},//3
			{false,false,false,true,false,false,false,false,false}, //4
			{false,false,false,false,false,false,false,false,false}, //5
			{false,false,false,false,false,false,false,false,false}, //6
			{false,false,true,true,false,false,false,false,false}, //7
			{false,false,false,false,false,false,false,false,false}  //8
	};
	
	public static void main(String[] args) {
		visit = new boolean[9];
		
		dfs(0);
		System.out.println(Arrays.toString(visit));
		
		bfs(0);
		System.out.println(Arrays.toString(visit));
		

	}
	static void dfs(int n) {

		visit[n] = true;
		System.out.println(n+"->");
		for (int i = 0; i <=4; i++) {
			if(!matrix[i][n] || visit[1])continue;
			dfs(i);
		}

			
	
		
	}

	static void bfs(int n) { //

		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(n);

		visit[n] = true;

		while(!q.isEmpty()) {
			int v = q.poll();

			for (int i = 0; i <=4; i++) {
				if(!matrix[v][i] || visit[v]) continue;
				visit[n] = true;
				q.offer(i);
				System.out.print(v+"-> ");	

			}
		}
	}

}
