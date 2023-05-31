package algo_live.graph2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import algo_live.graph2.AdListTest.Node;



public class AdListTest2 {
	
	static int v;
	static ArrayList<Integer>[] adList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v=sc.nextInt();
		int e=sc.nextInt();
		
		adList = new ArrayList[v]; //head가 null인 상태
		for(int i=0; i<v;i++) { //이렇게 미리 넣어 주어야 2차원 형태로 구성 할 수 있다.
			adList[i] = new ArrayList<Integer>();
		}
		
		
		int from, to;
		for (int i = 0; i < e; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			//무방향 그래프
			adList[from].add(to);
			adList[to].add(from);
			//방향그래프시 , 한쪽에만 적어준다
			//adList[from] = new Node(to,adList[from]);
		
		}
		bfs(0); 
		//print();
	}
	private static void bfs(int n) {
		Queue<Integer> que = new ArrayDeque<>();
		boolean visit[] = new boolean[v];
		visit[n] = true;
		que.offer(n);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			// 여기 서 visit 체크하면 안된다, 방문했을때가 아닌 방문하려고 큐에 넣었을때 체크해주어야한다.
			System.out.println((char)(now + 65)); //알파벳으로 출력
			for(int vertex : adList[now] ) { //현재 정점과 연결된곳으로 간다.
				if(visit[vertex]) continue;
				que.offer(vertex);
				visit[vertex] = true;
			}
			
			
		}

	}
	static void print() {
		for(ArrayList<Integer> a: adList) {
			System.out.println(a);
		}
	}

}
