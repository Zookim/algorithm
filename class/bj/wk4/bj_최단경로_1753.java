package bj.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//인접 행렬 사용, 메모리 초과
public class bj_최단경로_1753 {

	static int map[][];
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
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V =  Integer.parseInt(st.nextToken()); 
		int E =  Integer.parseInt(st.nextToken()); 
		
		int start =  Integer.parseInt(br.readLine()); 
		map = new int[V+1][V+1];
		dis = new int[V+1];
		visit = new boolean[V+1];
		for(int i=0;i<E;i++) { 
			st = new StringTokenizer(br.readLine());
			int f =  Integer.parseInt(st.nextToken()); 
			int r =  Integer.parseInt(st.nextToken()); 
			int w =  Integer.parseInt(st.nextToken()); 
			//방향?
			if(map[f][r] != 0) {
				int a=map[f][r];
				map[f][r] = a>w?w:a;
			}else {
				map[f][r] = w;
			}
			
		
		}
		 final int INF = Integer.MAX_VALUE;
		 Arrays.fill(dis, INF);
		

		 //입력 끝
		 //시작점으로 시작한다.
		 PriorityQueue<Edge> que = new PriorityQueue<>((n1,n2)->n1.cost-n2.cost);
		 visit[start] =true;
		 dis[start]=0;
		 for(int i=1;i<E;i++) {
			 if(map[start][i] !=0 && !visit[i]) {//아직 방문전이고 인접하면
				 dis[i] = map[start][i];
				 que.offer(new Edge(i,dis[i])); //비용과 정점시작점을 넣어준다.//?
				 
			 }
			 
		 }
		 
		// System.out.println(Arrays.toString(dis));
		 //다음
		 while(!que.isEmpty()) {
			 Edge now= que.poll();//빼본다
			 if(visit[now.no]) continue;//이미방문했다면
			 
			 visit[now.no] =true;
			 
			
			 //now로 부터 dis값을 변경한다.
			 for(int i=1;i<E;i++) {
				 if(map[now.no][i] !=0 && !visit[i] && dis[i] > now.cost +map[now.no][i] ) {//아직 방문전이고 인접하면,거비가 기존보다 짧아지면
					 dis[i] =  now.cost +map[now.no][i];
					 que.offer(new Edge(i,dis[i])); //바꾼 값을 다시 넣어준다.이후 다시 최소값이 나오도록
					 
				 }
				 
			 }
			 
			 
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
