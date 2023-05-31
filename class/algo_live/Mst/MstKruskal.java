package algo_live.Mst;


import java.util.Arrays;
import java.util.Scanner;

public class MstKruskal {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) { //양수가 나오면 교체한다,
			return Integer.compare(this.weight,o.weight);
			//Integer.compare(): 크다(1),작다(-1),같다(0)를 리턴
		}

	}
	
	static int E,V;
	static Edge[] edgeList;
	static int parents[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		edgeList = new Edge[E];
		
		for (int i = 0; i <E; i++) {
			edgeList[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		//정렬
		Arrays.sort(edgeList);
		
		makeSet();
		int result =0,count=0;
		
		for(Edge edge: edgeList) {  // 모든 간선을 돌면서 -> 이미 정렬되어 있으므로
			if(union(edge.from ,edge.to)) { // 사이클이 형성되지 않으면
				result += edge.weight; //가중치를 합하고
				if(++count == V-1) { //간선의 수를 체크
					break;
				}
			}
		}
		System.out.println(result);
		

	}
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) { //이미 같은 집합에 있으므로 해강간선을 이용하면 사이클이 생성된다, 따라서 사용하면 안된다.
			return false;
		}else {
			parents[bRoot] = aRoot;
			return true;
		}
		
	}
	static int findSet(int a) {
		if(parents[a] == a)return a;
		return parents[a] = findSet(parents[a]); //내려오면서 전부 교체
	}
	static void makeSet() {
		parents = new int[V];
		for(int i=0;i<V;i++) {
			parents[i]=i;
		}
	}

}
