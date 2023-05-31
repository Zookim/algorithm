package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 자료구조가 Array of ArrayList
//Friend 자료구조를 생성
//메모리 줄이기
public class bj_ABCDE_List2 {
	//G,R
	//상하좌우
	static int N,M;
	static int num=0;

	static Friend[] friends;
	static boolean done;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//같으면 수를 같은수로...
		N = Integer.parseInt(st.nextToken());//정점의 수
		M = Integer.parseInt(st.nextToken()); //간선의 수
		
		//Friend 배열 자료구조 생성
		friends = new Friend[N];
		for(int i=0;i<N;i++) {
			friends[i] = new Friend(i);
			}
		//양방향

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());		
			int end = Integer.parseInt(st.nextToken());
			
			//양방향
			friends[start].list.add(end);
			friends[end].list.add(start);
			
			
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
		
		//f에는 Friend 객체가 넘어간다.
		friends[num].list.forEach((n) ->{
			if((visit & 1<<n) == 0) dfs(n,cnt+1,visit|1<<n);
		});
		
		
	}
	static class Friend{
		//불필요한 메모리를 줄이기 위해서, 큰 차이는 없었다.
		int num;
		List<Integer> list = new ArrayList<>();
		Friend(int num){
			this.num = num;
		}
	}
//	static class Friend{
//		int num;
//		List<Friend> list = new ArrayList<>();
//		Friend(int num){
//			this.num = num;
//		}
//	}
//	
	
}
