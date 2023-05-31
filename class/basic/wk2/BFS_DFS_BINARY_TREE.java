package basic.wk2;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS_DFS_BINARY_TREE {
/*
   `                 1
               2           3
           4      5     6      7
         8  9  10  11  12 13  14 15
 
BFS ������ �μ� ���η� Ž��
DFS 1 2  4 9 -> 9 ->  5 10 11-> 3 6 12 13 ->7 14-> 15
 
  */
	
	
	
	
	
	//ù�ڸ��� ������.
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
		//���ȣ���� �ƴ� ť ���
		Queue<Integer> queue = new ArrayDeque<>();
		//�ʱⰪ queue�� ��´�.
		queue.offer(index);
		while( ! queue.isEmpty()) {
			int curIndex = queue.poll();
			sb.append(tree[curIndex]).append(" ");
			
			//�θ� curIndex�� ���� �� �� �ִ� �ڽ� -����Ʈ��
			int lcIndex = curIndex*2;
			int rcIndex = curIndex*2+1;
			if(lcIndex < tree.length) queue.offer(lcIndex);
			if(rcIndex < tree.length) queue.offer(rcIndex);
		}
	}
	static void dfs(int index) {
		//���ȣ��
		if(index >= tree.length)return; //��������
		sb.append(tree[index]).append(" ");
		
		dfs(index*2);
		dfs(index*2+1);
		
		
	}

}
