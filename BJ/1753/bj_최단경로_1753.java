package my.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_최단경로_1753 {

	//메모리 초과, 방향그래프
	static class Edge{
		int to;
		int w;
		public Edge(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		
	}
	static int V,E, start;
	static int dis[];
	final static int INF = Integer.MAX_VALUE;
	static boolean visit[];
	static  List<List<Edge>> AdjList = new ArrayList<>();
	static PriorityQueue<Edge> que = new PriorityQueue<>((e1,e2)->e1.w-e2.w);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		dis = new int[V+1];
		visit = new boolean[V+1];
		Arrays.fill(dis,INF);
		
		for(int i=0;i<=V;i++) {//1부터 시작
			AdjList.add(new ArrayList<Edge>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			//방향이 있는 인접행렬
			
			AdjList.get(from).add(new Edge(to,w));
			
		}
		//입력 완료 이제 최단경로를 구한다.
		StringBuilder sb = new StringBuilder();
		dijkstra();
		for(int i=1;i<=V;i++) {
			if(dis[i] == INF) {
				sb.append("INF").append("\n");
			}else {
				sb.append(dis[i]).append("\n");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}
	
	static void dijkstra() {
		que.offer(new Edge(start,0));
		dis[start] =0; 
		//visit[start] = true;//여기서하면 while문 바로 종료
		
		
		while(!que.isEmpty()) {
			Edge now = que.poll();
			//방문하지 않은곳만 유효하다.
			if(visit[now.to]) continue;
			visit[now.to] = true;//이제 방문했다. 큐에선 가장 작은것부터 나오므로
			
			for(Edge a :AdjList.get(now.to) ) {//현위치와 인접한곳
				if(dis[a.to] > dis[now.to] + a.w) { // 여기서 방문체크는 하지 않는다.
					dis[a.to] = dis[now.to] + a.w;//현재 위치의 최단이 아닌 거리값 > 이전까지의 최단경로 + 현재 위치의 가중치
					
					//!!!!!!!//
					a.w = dis[a.to]; //얘의 값을 변경해주어야 한다., 누적값을 가지고 경로를 수정하므로
					
					que.offer(a);//이 if문내에서 넣는이유는, 값을 갱신시키는 경우가 아니면 의미 없기때문이다(기존것은 이미)
					//들어가 있고, 굳이 값을 갱신시키지 못하는 큰값을 넣을 필요없다.
					
					//여기서 방문체크하지 않는이유는 뽑아내면서 최단경로를 확정하기 때문이다
					//여기선 일단 값들을 갱신하기만한다.
					//갱신해도 어차피 최단이 아니면 이후 연산에서 수정되게 된다.
				}
				
			}
			
		}
		
		
	}

}
