package algo_live.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;




public class DijkstraTest{
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
	
		int [][] Matrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				Matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		final int INF = Integer.MAX_VALUE;
		int [] dis = new int[V];
		boolean[] visited = new boolean[V];
		
		
		Arrays.fill(dis,INF);
		dis[start]=0;
		
		int min,current;
		for(int c = 0; c < V; c++) {
			//step1. 경유지로 선택되지 않은 정점중 출발지에서 가장가까운 정점 선택
			current =-1;
			min = INF;
			
			for (int i = 0; i < V; i++) {
				if(!visited[i] && min > dis[i]) { //이직방문전이고, 거리가 다른것보다 짧을때
					min = dis[i];
					current =i;
				}
			}
			if(current == -1)break; //인접하는 것이 없거나, 모두 방문해서 더이상 없는 경우
			else {visited[current] = true;} //아니면 경유한다.
			
			if(current == end) break;// 도달하면 끝
			 
			//step2.  위에서 현재 정점 경유지로 선택했으니, 거리값들을 현재값 기준으로 갱신해준다.
			
			for(int j = 0; j < V; j++) {
				if(!visited[j] && Matrix[current][j] !=0 && //아직 확정되지 않고, 비용이 0이 아닌 경로값에 대해 최단경로로 갱신하다.
						dis[j] > min+Matrix[current][j]) { // 최단경로가 맞다면,
					dis[j] =  min+Matrix[current][j];//갱신
					
					
				}
			}
			
		}
		
		System.out.println(dis[end] != INF ? dis[end]:-1);
		
		
	}



	
	
	
	

}
