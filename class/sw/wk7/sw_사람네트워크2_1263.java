package sw.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

// 빈 공간이 많은 희소 그래프가 테케를 구성할 때 bfs() 가 유리
public class sw_사람네트워크2_1263 {

	static ArrayList<Integer>[] adjList;
	static int min, N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[N];
			
			min = 3000;
			
			for (int i = 0; i < N; i++)
				adjList[i] = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						adjList[i].add(j);
					}
				}
			}
			
			// 모든 정점에서 bfs() 를 통해서 다른 점들을 다 방문하는 비용을 계산
			for (int i = 0; i < N; i++) {
				bfs(i);
			}
				
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int V) {
		
		Queue<Node> pqueue = new ArrayDeque<>();
		boolean[] visit = new boolean[N];
		
		visit[V] = true;
		pqueue.add(new Node(V, 0));
		
		int dist = 0;
		
		while (!pqueue.isEmpty()) {
			
			Node node = pqueue.poll();
			
			for (int v : adjList[node.v]) {
				
				if ( visit[v] ) continue;
				
				dist += node.cnt + 1;
				if (dist >= min) return;
				
				visit[v] = true;
				pqueue.add(new Node(v, node.cnt + 1));
			}
		}
		
		if (dist >= min) return;
		
		min = dist;
	}
	
	static class Node {
		int v, cnt;

		public Node(int to, int cnt) {
			this.v = to;
			this.cnt = cnt;
		}
	}
}
