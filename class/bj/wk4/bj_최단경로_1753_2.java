package bj.wk4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//안됨
public class bj_최단경로_1753_2 {

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
		
		int start =  Integer.parseInt(br.readLine()); 
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
		 PriorityQueue<Edge> que = new PriorityQueue<>((n1,n2)->n1.cost-n2.cost);
		 visit[start] =true;
		 dis[start]=0;

		 for(Edge a : List.get(start)) {
			 dis[a.no] = a.cost ;
			 que.offer(new Edge(a.no,dis[a.no])); 
		 }
	



	// System.out.println(Arrays.toString(dis));
	//다음
		//ture; 위치와 값 비교
		 while(!que.isEmpty()) {
			 Edge now= que.poll();//빼본다
			 if(visit[now.no]) continue;//이미방문했다면
			 visit[now.no] =true;
			 
			
			 //now로 부터 dis값을 변경한다.

			 for(Edge a :List.get(now.no)) { //기존 값
				if(dis[a.no] > now.cost + a.cost ) {
					 dis[a.no] = now.cost+ a.cost ;
					 que.offer(new Edge(a.no,dis[a.no])); 
				} 
			 }
			 //System.out.println(Arrays.toString(dis));
			 
			 
		 }

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

}
