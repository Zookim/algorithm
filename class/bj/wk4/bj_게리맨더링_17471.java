package bj.wk4;
//된다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_게리맨더링_17471 {

	//인구차이의 최소값
	
	static int N;
	static long sum;

	
	static int parents[];
	static int Num[][];
	static int total=0;
	static boolean[] visit; 
	static int two[] = {-1,-1};
	static int Asum =0,Bsum=0;
	static List<List<Integer>> adjlist = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		makeSet(N+1);
		
		for(int i=0;i<=N;i++) {
			adjlist.add(new ArrayList<Integer>());
		}

		Num = new int[N+1][2];
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			Num[i][0] = Integer.parseInt(st.nextToken()); //인구수
			Num[i][1] = i; //구역
			total+=Num[i][0];
		}
		
		Arrays.sort(Num,(n1,n2) -> n1[0] - n2[0]); //작은 값부터 
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int n =  Integer.parseInt(st.nextToken());
			for(int j=0;j<n;j++) {
				int a = Integer.parseInt(st.nextToken());
				adjlist.get(i).add(a);
				union(i,a);
			}
		}
		//입력
		
		
		System.out.println(Arrays.toString(parents));
		int now = Num[1][1];// 구역
		Asum += Num[1][0];
		two[0] = findSet(now);//
		//1번 값부터 시작한다.
		//정렬되어 있으므로 모두같다면, 절반부터 더한다.
		System.out.println(Hmm());
		

		

	}
	static int min = Integer.MAX_VALUE;
	static int Hmm() {
		
		for(int i=2;i<=N;i++) { //순차적으로 각 노드를 방문해 확인한다.
			int now = Num[i][1];
			int set = findSet(now);

			if(set == two[0]) {
				Asum += Num[1][0];

			}else {
				if(two[1] == -1 && two[1] == set) {// 다른 첫 값
					two[1] = now;
					Bsum+= Num[1][0];
				}else { //아예 다를 경우 버린다.
					return -1;
				}

			}
			int t =  Math.abs(Bsum-Asum);
			min = t > min? min:t;


		}
		System.out.println(Asum+ " "+ Bsum);
		return min;

	}
	
	
	
	static boolean same(int a,int b) {
		
		
		if(findSet(a) == findSet(b)) {
			return true;
		}else return false;
	}
	static void union(int a,int b) { //A에 흡수된다.
		if(findSet(a) == findSet(b)) {
			return;
		}else {
			parents[findSet(b)] =findSet(a);
		}
	}
	static void makeSet(int n) {
		parents = new int[n];
		for(int i=0;i<n;i++) {
			parents[i] =i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}else {
			return parents[a] = findSet(parents[a]);
		}
	}
}


