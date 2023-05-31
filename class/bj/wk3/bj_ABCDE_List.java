package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class bj_ABCDE_List {
	//G,R
	//상하좌우
	static int N,M;
	static int num=0;

	static List<List<Integer>> friends = new ArrayList<>();
	static boolean done;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//같으면 수를 같은수로...
		N = Integer.parseInt(st.nextToken());//정점의 수
		M = Integer.parseInt(st.nextToken()); //간선의 수
		
		for(int i=0;i<N;i++) {
			friends.add(new ArrayList<Integer>());
		}
		//양방향

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());		
			int end = Integer.parseInt(st.nextToken());
			
			//양방향
			friends.get(start).add(end);
			friends.get(end).add(start);
			
		}
		//모든 사람 각각에 대해서 연속적으로 연결된 친구관계가 5명인 경우를 찾는다.
		
	
		for(int i=0;i<N;i++) { //사람 수 만큼
	
			dfs(i,0,1<<i);
			if(done) {
				System.out.println(1);
				return;
			}
		
		}
	
		
		//연속적인 관계가 없는 경우
		System.out.println(0);

	}
	static void dfs(int num, int cnt, int visit) {
		//연속적인 관계가 생기면 done을 true로
		if(done) return;
		//연속적인 5명의 친구가 성립
		if(cnt ==4) { //왜 ?
			done = true;
			return;
		}
		
		//i에는  friends.get(num)의 원소들이 차례로넘어온다
		friends.get(num).forEach((i) ->{
			if((visit & (1<<i)) == 0) dfs(i,cnt+1,visit|1<<i);
		});
		
		
	}
	
	
}
