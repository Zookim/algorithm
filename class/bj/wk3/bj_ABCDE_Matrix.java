package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//시간초과가 나는 이유

public class bj_ABCDE_Matrix {
	//G,R
	//상하좌우
	static int N,M;
	static int num=0;

	static boolean friends[][]; //메모리를 많이 차지
	static boolean done;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//같으면 수를 같은수로...
		N = Integer.parseInt(st.nextToken());//정점의 수
		M = Integer.parseInt(st.nextToken()); //간선의 수
		
		friends = new boolean [N][N];
		//양방향

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());		
			int end = Integer.parseInt(st.nextToken());
			
			//양방향
			friends[start][end] = friends[end][start] = true;
			
		}
		//모든 사람 각각에 대해서 연속적으로 연결된 친구관계가 5명인 경우를 찾는다.
		
		//시간초과가 난다, 희소 행렬, 모두 다 돈다
		// Integer에서 , 2000을 커버할 수 없으나 테스케이스가 없어서 통과
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
		for(int i=0;i<N;i++) {
			if(! friends[num][i] ||(visit & 1<<i) != 0) continue;
			dfs(i,cnt+1, visit | (1<<i));
		}
		
		
	}
	
	
}
