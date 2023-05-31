package sw.wk4;
//된다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw_최소스패닝트리_3124_c1 {

	//가중치 합이 최소인 트리
	static int T,V,E;
	static long sum;
	static int[] parents;
	static Edge[] edges;
	
	static class Edge{
		int from;
		int to;
		int cost;
		public Edge(int from,int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			parents = new int[V+1];
			edges = new Edge[E];
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to =  Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				edges[i] = new Edge(from,to,cost);


			}
			//입력 ,  1에서 시작
			sum=0;
			
			Arrays.sort(edges, (e1,e2)-> e1.cost-e2.cost);
			
			
			makeSet();
			
			// 사이클이 생성되지 않도록 최소 값을 가지는 간선을 선택, V-1개 선택
			int cnt =0;
			for(int i=0;i<E;i++) {
				Edge edge =  edges[i];

				if(union(edge.from,edge.to)) { // 사이클이 없으면
					cnt++;
					sum += edge.cost;
				}
				if(cnt == V-1) {
					break;
				}
				System.out.println("#"+test_case+" "+sum);

			}


		}


	}
	static boolean union(int a,int b) {
		int ap = findSet(a);
		int bp = findSet(b);
		if(ap == bp) {
			return false;
		}else {
			parents[ap] =bp;
			return true;
		}
		
		
	}
	static void makeSet() {
		for(int i=1;i<=V;i++) {
			parents[i] = i;
		}
		
	}
	static int findSet(int i) {
		if(parents[i] ==i) {
			return i;
		}else {
			//return findSet(arr[i]); //시간초과
			return parents[i] = findSet(parents[i]); //Path Compression // i를 올라가면서 부모들도 같이 부모를 변경한다.
		}
	}

}
