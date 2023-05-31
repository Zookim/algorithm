package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_도시분할계획_1647 {
	//두개의 마을로 분할 한다.
	//집이 최소하나는 있어야한다.
	
	static int V,E;
	static class Edge{
		int from;
		int to;
		int cost;
		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}


	}
	static Edge list[];

	static int parents[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new Edge[E];

		makeSet(V);
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		//입력

		Arrays.sort(list,(n1,n2) -> n1.cost - n2.cost);// 오름 차순 정렬

		int res = 0;
		int count=0;
		int last=0;
		for(int i=0;i<E;i++) { //그냥 모든 간선을 차례로 확인
			if(union(list[i].from,list[i].to)) {//사이클이 없다면 선택
				count++;
				res += list[i].cost;
				last = list[i].cost;;
			}

			if(count == (V-1)) {
				break;
			}
		}
		//연결된 것중 가장 비용이 큰길을 ㄷㅏ시 잘라낸다.
		System.out.println(res-last);



	}
	static void makeSet(int n) {
		parents = new int[n+1];
		for(int i=1;i<=n;i++) {
			parents[i] =i;
		}
	}
	static int findSet(int a) {
		if(parents[a] ==a)return a;
		else {
			return parents[a] = findSet(parents[a]);
		}

	}
	static boolean union(int a, int b) {
		int ap = findSet(a);
		int bp = findSet(b);
		if(ap == bp) {
			return false;
		}else {
			parents[ap] = bp;
			return true;
		}


	}

}
