package bj.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//강의 코드
public class bj_최단경로_1753_3 {

	//static int map[][];
	static int dis[];
	static boolean visit[];
	static class Edge{
		int no;
		int cost;
		public Edge(int no, int cost) {
			super();
			this.no = no;
			this.cost = cost;
		}
		
	}
	static int start;
	static  PriorityQueue<Edge> que = new PriorityQueue<>((n1,n2)->n1.cost-n2.cost);
	static List<List<Edge>> List= new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V =  Integer.parseInt(st.nextToken()); 
		int E =  Integer.parseInt(st.nextToken()); 
		
		for(int i=0;i<=V;i++) {
			List.add(new ArrayList<Edge>());
		}
		
		start =  Integer.parseInt(br.readLine()); 
		//map = new int[V+1][V+1];
		dis = new int[V+1];
		visit = new boolean[V+1];
		
		for(int i=0;i<E;i++) { 
			st = new StringTokenizer(br.readLine());
			int f =  Integer.parseInt(st.nextToken()); 
			int r =  Integer.parseInt(st.nextToken()); 
			int w =  Integer.parseInt(st.nextToken()); 
			//방향?
			
			List.get(f).add(new Edge(r,w));
		
		}
		 final int INF = Integer.MAX_VALUE;
		 Arrays.fill(dis, INF);
		

		 //입력 끝
		 //시작점으로 시작한다.
		
		 dis[start]=0;
		 
		 dijkstra();
		 
		
		
		 
		 for(int i=1;i<=V;i++) {
			 int s = dis[i];
			 if(s==INF) {
				 sb.append("INF").append("\n");
			 }else {
				 sb.append(s).append("\n");
			 }
		 }
		 System.out.println(sb);
		
		

	}
	
	static void dijkstra() {
		
		dis[start] =0;
		que.offer(new Edge(start,0));
		
		
		while(!que.isEmpty()) {
			 Edge now= que.poll();//빼본다
			 if(visit[now.no]) continue;//이미방문했다면
			 visit[now.no] =true;

			 for(Edge a :List.get(now.no)) {
				 //now로 부터 dis값을 변경한다.
				 if( dis[a.no] > dis[now.no] + a.cost ) { // 
					 dis[a.no] =  dis[now.no]+ a.cost ;

					 que.offer(new Edge(a.no,dis[a.no])); 
				 } 
				 //System.out.println(Arrays.toString(dis));

			 }
		}

	}
	static void dijkstra2() { //visit 사용위치 차이, 안됨

		dis[start] =0;
		visit[start] = true;
		que.offer(new Edge(start,0));


		while(!que.isEmpty()) {
			Edge now= que.poll();//빼본다

			visit[now.no] =true;


			//now로 부터 dis값을 변경한다.
			for(Edge a :List.get(now.no)) {
				if(!visit[a.no] && dis[a.no] > dis[now.no] + a.cost ) { // 
					dis[a.no] =  dis[now.no]+ a.cost ;
					
					visit[a.no] = true; // 넣을때가 아니라 빼낼때 true로 체크해야한다.
					que.offer(new Edge(a.no,dis[a.no])); 
				} 
			}
			//System.out.println(Arrays.toString(dis));


		}

	}

}
