package bj.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import bj.wk4.bj_낚시왕_17143.Fish;
import bj.wk4.bj_낚시왕_17143_c.Shark;

public class bj_아기상어_16236_c {
	//가장 위 가장 왼쪽
	//몇초동안?
	static int N;
	static int sx,sy,sSize,sEatcnt,ans;
	
	static int map[][];

	static Queue<Node> que = new ArrayDeque<>();
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visit[][];
	

	static class Node{
		int y,x,d;

		public Node(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st;
		N =  Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				
				map[i][j] =  a;
				if(a == 9) {//상어 위치
					sy=i;sx=j;
					
				}
			}
		}
		sSize =2;
		
		
		while(true) {
			int cnt = bfs(); //가장 가까운 물고기 거리를 반환한다.
			if(cnt ==0) break; // 더이상 먹을 수 있는 것이 없다.
			ans+= cnt; //누적거리(시간)
		}
		System.out.println(ans);
		
		
	}
	
	
	static int bfs() {
		//먹이 후보를 제일 작은 것으로 구하기이해
		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minDis = Integer.MAX_VALUE;
		
		//visit 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = false;
			}
		}
		
		//시작을 위한 노드
		visit[sy][sx] = true;
		que.offer(new Node(sy,sx,0));
		
		while(!que.isEmpty()) {
			Node node=que.poll();
			//먹을 수 있는 것이 있는지, 물고기가 있고 , 그크기가 상어보다 작아야한다.
			if(map[node.y][node.x] != 0 && map[node.y][node.x]<sSize) {
				if(node.d < minDis) {//거리가 같으면
					minDis = node.d;
					minY = node.y;
					minX = node.x;
				}else if(node.d == minDis) {//거리가 같으면
					if(node.y < minY) {//거리가 같으면
						minDis = node.d;
						minY = node.y;
						minX = node.x;
					}else if(node.y == minY) {//거리가 같으면
						if(node.x < minX) {//거리가 같으면
							minDis = node.d;
							minY = node.y;
							minX = node.x;
						}
					}

				}
				
			}
			
			if(node.d+1 >=minDis) continue;
			//다음 경우의 수를 따진다.
			for(int d=0;d<4;d++) {
				int ny = node.y +dy[d];
				int nx = node.x +dx[d];


				if(nx <0 || nx>=N ||ny <0 || ny>=N || visit[ny][nx] || map[ny][nx] > sSize) continue;
				visit[ny][nx] = true;
				que.offer(new Node(ny,nx,node.d+1));
			}
			
		}
		if(minDis ==Integer.MAX_VALUE)return 0; //물고기를 못찾는경우
		else {
			sEatcnt++;
			if(sEatcnt ==sSize) {
				sSize++;
				sEatcnt = 0;
			}
			
			map[minY][minX] =0;//물고기자리 0
			map[sy][sx] =0; //상어자리0
			
			sy = minY;
			sx =  minX;
			
		}
		return minDis;



	}

	

	

}
