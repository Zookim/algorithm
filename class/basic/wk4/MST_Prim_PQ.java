package basic.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import basic.wk4.MST3_Prim_Matrix_PQ.Vertex;
 
//프림 알고리즘 이용 : PriorityQueue 버전
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0
==>175
 */
/**
 * @author THKim
 */
public class MST_Prim_PQ{


	static class Edge{
		int no; 
		int weight;
		public Edge(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] input = new int[N][N];
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>((e1,e2) -> e1.weight - e2.weight);//

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}

		}// i노드에서 j노드까지의 비용을 모두 배열에 저장

		int result = 0;

		//0넙 정점부터 선택하고 시작한다.
		//처음 갈수 있는 것들을 넣고 시작하므로 1에서 시작한다.
		int nodeCount= 1; //0번 이미 선택
		visited[0] = true;

		for (int i = 0; i < N; i++) {
			if(input[0][i] !=0) pq.offer(new Edge(i,input[0][i]));
		}
		while(!pq.isEmpty()){

			Edge minVertex = pq.poll();
			if(visited[minVertex.no]) continue;


			//minVertex는 PQ에 의해 면결가능한 정점중 최소비용의 정점이 선택된 상태
			result += minVertex.weight;
			visited[minVertex.no] = true; 
			if(++nodeCount == N) break; 

			//minVertex가 갈 수 있는 정점중 아직 방문하지 않는 정점을 큐에 담는다.
			for (int i = 0; i < N; i++) { // 인접한 노드 중  방문하지 않은 노드에 대해 간선비용 최소값으로 갱신
				if (!visited[i] && input[minVertex.no][i] != 0) {
					pq.offer(new Edge(i, input[minVertex.no][i])); 
				}
			}
		}
		System.out.println(result);

	}
}// end class
