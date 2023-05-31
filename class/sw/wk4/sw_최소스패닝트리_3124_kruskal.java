package sw.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw_최소스패닝트리_3124_kruskal {

	//가중치 합이 최소인 트리
	static class Edge{
		int no;
		int cost;
		public Edge(int no, int cost) {
			super();
			this.no = no;
			this.cost = cost;
		}
		
	}
	static Edge [] edgeList;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			visited = new boolean[V+1];
			edgeList = new Edge[E];
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to =  Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edgeList[from] = new Edge(to,cost);
				
			}
			//입력 ,  1에서 시작
			int res=0;
			int count=1;
			PriorityQueue<Edge> que = new PriorityQueue<>((e1,e2)-> e1.cost - e2.cost);
			visited[1] =true;
			for(int i=1;i<=V;i++) {
				if(input[1][i] != 0 && !visited[i]) {
					//System.out.println("input "+ input[1][i]);
					que.offer(new Edge(i,input[1][i]));
				}
			}
			
			while(!que.isEmpty()) {
				Edge now = que.poll(); // 가장 경로가 최소인것이 나온다
				//지금것이 방문되었던 것인지 확인한다.
				if(visited[now.no]) continue;
				visited[now.no] =true;
				
				res += now.cost;
				//System.out.println(res +" "+ now.cost);
				if(++count == V) break;
				//아니라면 가중치를 저장한다.
				// 모든 정점이 선택되었으면 종료
				// 아니라면 다음 것을 찾는다.
				for(int i=1;i<=V;i++) { //다음으로 가기에 적합한것을 큐에 넣는다.
					if(!visited[i] && input[now.no][i] !=0) {
						//System.out.println("2ss "+ i);
						que.offer(new Edge(i,input[now.no][i]));
					}
				}
				
				
				
			}
			System.out.println("#"+test_case+" "+res);
			
			
			
			
			
		}
		
		
	}

}
