package algo_live.TopologySort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSTopologySort {

	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	
	static int N,M;
	static Node [] adjList;
	static int[] inDegree ;//진입차수 관리
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N =Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		inDegree = new int[N+1];//각노드의 집입간선을 센다.
		
		int from,to;
		for (int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			 from = Integer.parseInt(st.nextToken());
			 to = Integer.parseInt(st.nextToken());
			 adjList[from] = new Node(to,adjList[from]);
			 inDegree[to]++;//진입이 있는것을 센다.
		}
		
		ArrayList<Integer> res = topolgySort();
		if(res.size() == N) {
			for(Integer a: res) {
				System.out.print(a+" ");
			}
		}
		else {
			System.out.print("cycle");
		}
	}
	static ArrayList<Integer> topolgySort(){
		Queue<Integer> que = new ArrayDeque<Integer>();
		ArrayList<Integer> orderList = new ArrayList<>();
		for (int i = 1; i <=N; i++) {
			if(inDegree[i]==0) que.offer(i);
		}
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			orderList.add(cur);//순서대로 저장한다.
			
			//인접 노드들을 제거한다.
			for(Node temp = adjList[cur]; temp != null;temp = temp.link) {//cur과 인접한 노드가 있으면
				if(--inDegree[temp.vertex]==0) {// 그 노드의 값을 줄인다.0이되면 큐에 넣는다.
					que.offer(temp.vertex);
				}
			}

		}
		return orderList;
		
	}

}
