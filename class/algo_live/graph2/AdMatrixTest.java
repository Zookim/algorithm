package algo_live.graph2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdMatrixTest {

	static int adMatrix[][];
	static int V ,e;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V=sc.nextInt();
		e=sc.nextInt();
		
		adMatrix = new int [V][V]; //모두 0올 초기화

		int from, to;
		for (int i = 0; i <e; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			//무방향 그래프
			adMatrix[to][from] = adMatrix[from][to] = 1;
			//방향그래프시 , 한쪽에만 적어준다
			//adMatrix[from][to] = 1;
		
		}
		print();
		bfs(0) ;
		System.out.println();
		dfs(0,new boolean [V]);

	}
	
	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		
		System.out.print((char)(current + 65)+" ");
		
		//자신의 인접행렬 확인
		for(int i=0;i<V;i++) {
			if(adMatrix[current][i] != 0 && !visited[i]) {
				dfs(i,visited);
			}
		}
	}
	
	private static void bfs(int n) {
		Queue<Integer> que = new ArrayDeque<>();
		boolean visit[] = new boolean[V];
		visit[n] = true;
		que.offer(n);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			// 여기 서 visit 체크하면 안된다, 방문했을때가 아닌 방문하려고 큐에 넣었을때 체크해주어야한다.
			System.out.print((char)(now + 65)+" "); //알파벳으로 출력

			for(int i=0;i<V;i++) {
				if(adMatrix[now][i] == 0 || visit[i]) continue;
				que.offer(i);
				visit[i] = true;
			}
			
			
		}

	}
	static void print() {
		for(int [] a: adMatrix) {
			System.out.println(Arrays.toString(a));
		}
	}

}
