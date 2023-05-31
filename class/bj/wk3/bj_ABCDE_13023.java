package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//일렬로 되는 경우가 있는지 없는지, 5명

public class bj_ABCDE_13023 {
	//G,R
	//상하좌우
	static int N,M;
	static int num=0;
	
	static List<List<Integer>> map = new ArrayList<List<Integer>>();
	static List<List<Integer>> list = new ArrayList<List<Integer>>();
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//같으면 수를 같은수로...
		N = Integer.parseInt(st.nextToken());//정점의 수
		M = Integer.parseInt(st.nextToken()); //간선의 수
		
		visit = new boolean [N];
		//양방향
		for(int i=0;i<N;i++) {
			map.add(new ArrayList<Integer>());
		}
		

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());		
			int end = Integer.parseInt(st.nextToken());
			
			//양방향
			map.get(start).add(end);
			map.get(end).add(start);
			
		}
		for(int i=0;i<N;i++) {
			visit[i]=true;
			dfs(i,1);
			visit[i]=false;
			//System.out.println();
			if(num == 1) break;
		}
	
		
		
		System.out.println(num);

	}
	static void dfs(int n,int c) {
		//System.out.println(n);
		//System.out.println(c+"c");
		if(c >= 5) {num=1; return;}
		
		
		
		List<Integer> list = map.get(n);
		for(int a :list) {
			if(visit[a])continue;
			visit[a]=true;
			dfs(a,c+1);
			visit[a] =false;
		}
		
		return;

		
	}
	
	
}
