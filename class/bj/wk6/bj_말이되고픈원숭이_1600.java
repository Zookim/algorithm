package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_말이되고픈원숭이_1600 {

	static int K,W,H;
	static int[][] map;
	static boolean[][][] visit;
	
	//4방
	static int[] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	//8방
	static int[] hdr = {-2,-2, -1,-1,1,1,2,2};
	static int[] hdc = {1,-1,2,-2,2,-2,1,-1};
	
	//bfs Node
	static Queue<Node> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map =new int[H][W];
		visit = new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		bfs();
	}
	static void bfs() {
		Node n= new Node(0,0,K,0);
		queue.offer(n);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			//목표에 도달했는지 확인
			if(node.r == H-1 && node.c==W-1) {
				System.out.println(node.d);
				return;
			}
			
			//탐색 1- 원숭이 이동
			for (int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				
				//range .visit확인
				if(nr <0 || nc <0 || nr >= H || nc >=W || map[nr][nc]==1 || visit[nr][nc][node.k]) continue;
				
				visit[nr][nc][node.k] = true;
				queue.offer(new Node(nr,nc,node.k,node.d+1));
			}
			//탐색 2 말로 이동한다. K조건을 따진다.
			if(node.k ==0) continue;//
			for (int i = 0; i < 8; i++) {
				int nr = node.r + hdr[i];
				int nc = node.c + hdc[i];
				
				//range .visit확인
				//
				if(nr <0 || nc <0 || nr >= H || nc >=W || map[nr][nc]==1 || visit[nr][nc][node.k - 1]) continue;
				
				visit[nr][nc][node.k - 1] = true;
				queue.offer(new Node(nr,nc,node.k-1,node.d+1));
			}
			
		}
		
		System.out.println(-1);
	}
	static class Node{
		int r,c,k,d;
		Node(int r, int c, int k,int d){
			this.r=r;
			this.c=c;
			this.k=k;
			this.d=d;
		}
	}
}
