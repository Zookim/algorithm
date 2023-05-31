package basic.wk2;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS_DFS_BINARY_TREE {
/*
   `                 1
               2           3
           4      5     6      7
         8  9  10  11  12 13  14 15
 
BFS 위에서 부서 가로로 탐색
DFS 1 2  4 9 -> 9 ->  5 10 11-> 3 6 12 13 ->7 14-> 15
 
  */
	
	
	
	
	
	//첫자리는 버린다.
	//static int[] tree = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	static int[] tree = {0,1,20,3,40,5,60,7,80,9,100,11,120,13,140,15};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		bfs(1);
		System.out.println(sb);
		sb.setLength(0);

		dfs(1);
		System.out.println(sb);
	}
	static void bfs(int index) {
		//재귀호출이 아닌 큐 사용
		Queue<Integer> queue = new ArrayDeque<>();
		//초기값 queue에 담는다.
		queue.offer(index);
		while( ! queue.isEmpty()) {
			int curIndex = queue.poll();
			sb.append(tree[curIndex]).append(" ");
			
			//부모 curIndex로 부터 갈 수 있는 자식 -이진트리
			int lcIndex = curIndex*2;
			int rcIndex = curIndex*2+1;
			if(lcIndex < tree.length) queue.offer(lcIndex);
			if(rcIndex < tree.length) queue.offer(rcIndex);
		}
	}
	static void dfs(int index) {
		//재귀호출
		if(index >= tree.length)return; //기저조건
		sb.append(tree[index]).append(" ");
		
		dfs(index*2);
		dfs(index*2+1);
		
		
	}

}
