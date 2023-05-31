package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_최소비용구하기_1916 {

	static class Edge{
		int to;
		int w;
		public Edge(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		
	}
	static int N,E,start,end;
	static int dis[];
	static boolean visit[];
	final static int INF = Integer.MAX_VALUE;
	static List<List<Edge>> adjList = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		dis =new int[N+1];
		Arrays.fill(dis,INF);
		
		visit =new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			adjList.add(new ArrayList<Edge>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			//무방향?
			adjList.get(from).add(new Edge(to,w));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		//입력 완료
		
		Dijkstra();
		System.out.println(dis[end]);
		//System.out.println(Arrays.toString(dis));
		
		

	}
	static PriorityQueue<Edge> que = new PriorityQueue<>((e1,e2) -> e1.w-e2.w);
	static void Dijkstra() {
		dis[start] =0;
		que.offer(new Edge(start,0));
		
		while(!que.isEmpty()) {
			Edge now = que.poll();
			
			if(visit[now.to]) continue;
			visit[now.to] = true;
			if(now.to == end) break;
			
			// 인접한 정점중 값을 갱신하는 것들을 큐에 넣는다, 또한 넣을때 비용은 누적값을 넣어 이후연산을 편리하게한다.
			for(Edge edge : adjList.get(now.to)) {//얘와 인접하는 노드들
				if(dis[edge.to] > edge.w + now.w) {//저장된 여기까지의 경로>추가된값+직전까지의 최단 값
					dis[edge.to] = edge.w + now.w;
					edge.w += now.w;
					que.offer(edge);
				}
				
			}
			
		}
	}

}
