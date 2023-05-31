package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//출력안됨
public class bj_DFS와BFS_1260_c3 {
	//1.인접 행렬로
	
	//정점의 번호가 작은것먼저
	//간선은 양방향
	static StringBuilder sb;
	static int N,M,V;
	static boolean[][] matrix; //visit대신 matrix의dummy를 visit로 활용한다.
	static Queue<Integer> queue = new ArrayDeque<>();
	//static boolean visit[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[N+1][N+1];

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			//양방향이므로 양쪽에 넣어준다.
			matrix[start][end] = true;
			matrix[end][start] = true;
		}
		
		//인접 행렬은 for문에서  i작은 순으로 처리하므로 , 문제에서 조건으로 주어진, 작은수 부터 출력하라는 것을
		// 추가로 고려하지 않아도 된다.
	
		
		sb = new StringBuilder();
		//visit = new boolean[N+1]; //dummy
		dfs(V); 
		sb.setCharAt(sb.length()-1, '\n'); //마지막문자를 개행으로 추가? 변경 ?
		//
		for(int i=1;i<=N;i++) {
			matrix[i][0] = false; //visit로 사용
		}
		//
		//visit = new boolean[N+1]; //dummy
		bfs(V);
		
		sb.setLength(sb.length() -1); //맨뒤의 문자를 없앨 수 있다
		
		System.out.println(sb);

	}

	static void dfs(int n) {
		matrix[n][0] = true;
		
		sb.append(n).append(" ");
		
		for(int i=1;i<=N;i++) {
			if(!matrix[n][i] ||matrix[i][0]) continue;
			dfs(i);
		}

	}
	static void bfs(int n) {
		queue.offer(n);
		matrix[n][0] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			
			for(int i=1;i<=N;i++) {
				if(!matrix[n][i] || matrix[i][0]) continue;
				queue.offer(i);
				matrix[i][0] = true;
			}
			
		}
		
	}

}
