package basic.wk4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author THKim
 */
public class Dijkstra_PQ {

	static int cnt;
	static class Edge{
		int no;
		int totalDistance;
		public Edge(int no, int totalDistance) {
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		st = new StringTokenizer(in.readLine().trim());
		int start = 0;
		int end =  V-1; //도착점 인덱스
		final int INF = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V]; //시작정점으로부터의 거리 (비용)
		boolean[] visited = new boolean[V];// 정점 선택여부
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim());
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		Arrays.fill(distance, INF);
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>((e1,e2) ->e1.totalDistance - e2.totalDistance);
		
		//입력 및 생성 완료//
		
		//시작정점 0 :시작점 설정
		distance[start] = 0;
		pQueue.offer(new Edge(start,distance[start]));
		
		Edge current = null;
        while(!pQueue.isEmpty()){
			
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
        	current = pQueue.poll();
        	if(visited[current.no])continue;
        	
			visited[current.no] = true; // 선택 정점 방문 처리
			if(current.no == end) break; // 선택 정점이 도착정점이면 탈출.
			
			//b단계: current정점을 경유지로 하여 갈수 있는, 아직 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!visited[c] && matrix[current.no][c] != 0 //방문전 && 현재 정점과 인접 && 경유하는경우가 더 짧을때
						&&  distance[c] >current.totalDistance+matrix[current.no][c]){
					//이전정점에 의해 결정된 비용  > 현재 정점의 까지의 가중치 + 현재정점에서 다음정점간의 비용
					distance[c] = current.totalDistance+matrix[current.no][c];
					pQueue.offer(new Edge(c,distance[c]));
				}
			}
		}
        System.out.println(distance[end] != INF ? distance[end] : -1);
		
	}

}