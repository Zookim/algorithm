package algo_live.graph2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdListTest {
	
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	static int v;
	static Node[] adList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v=sc.nextInt();
		int e=sc.nextInt();
		
		adList = new Node [v]; //head가 null인 상태

		int from, to;
		for (int i = 0; i <e; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			//무방향 그래프
			adList[from] = new Node(to,adList[from]);
			adList[to] = new Node(from,adList[to]);
			//방향그래프시 , 한쪽에만 적어준다
			//adList[from] = new Node(to,adList[from]);
		
		}
		bfs(0);
		System.out.println();
		dfs(0, new boolean [v]);
		//print();
	}
	private static void dfs(int n,boolean [] visit) {
		visit[n] = true;
		
		System.out.print((char)(n + 65)+" ");
		for(Node temp = adList[n]; temp != null; temp = temp.link) {
			if(visit[temp.vertex]) continue;
			
			dfs(temp.vertex,visit);
		}
		
		
	}
	
	
	
	private static void bfs(int n) {
		Queue<Integer> que = new ArrayDeque<>();
		boolean visit[] = new boolean[v];
		visit[n] = true;
		que.offer(n);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			// 여기 서 visit 체크하면 안된다, 방문했을때가 아닌 방문하려고 큐에 넣었을때 체크해주어야한다.
			System.out.print((char)(now + 65)+" "); //알파벳으로 출력
			for(Node temp =adList[now]; temp !=null;temp = temp.link ) { //현재 정점과 연결된곳으로 간다.
				if(visit[temp.vertex]) continue;
				que.offer(temp.vertex);
				visit[temp.vertex] = true;
			}
			
			
		}

	}
	static void print() {
		for(Node a: adList) {
			System.out.println(a);
		}
	}

}
