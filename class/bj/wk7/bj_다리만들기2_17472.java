package bj.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_다리만들기2_17472 {

	//섬 A와 B를 연결하는 다리가 중간에 섬 C와 인접한 바다를 지나가는 경우에 섬 C는 A, B와 연결되어있는 것이 아니다. 
	//다리의 길이는 2 이상
	//교차하는 다리의 길이를 계산할 때는 각 칸이 각 다리의 길이에 모두 포함되어야 한다
	
	// 0: 바다, 1: 땅
	// 모든 섬을 연결하는 다리길이의 최소값은 ? 
	// 불가능하면 -1
	
	//1. 지도를 보고 각 섬간으연결 가능한 것을 모두 구한다. -> 1이하이면 간선이 없는 것
	//BFS로 각섬의 번호를 매긴다. -> 모든 방향으로 뻗어가며 간선의 최소길이를 구한다. -> 인접 행렬이 만들어지면 -> MST로 구한다.(크루스칼)
	static int N,M,landnum;
	static int map[][];
	static boolean visit[][];
	
	static int [] dr =  {-1,1,0,0};
	static int [] dc =  {0,0,-1,1};
	//static List<List<Edge>> adjlist = new ArrayList<>();
	static int adjmatrix[][];
	
	static class Edge{
		int end,weight;
	}
	static final int INF=999; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map =  new int[N][M];
		visit =  new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력끝
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j] && map[i][j]==1) { //방문했거나 0인곳은 고려하지 않는다.
				bfs(i,j);
				}
			}
		}
		print(); //완료
		
		//행렬 만들기
//		
//		for(int i=0;i<landnum;i++) { // 섬의 수만큼 만든다, 대칭적이다.
//			adjlist.add(new ArrayList<Edge>());// i에서 출발하는 간선의 도착지와 다리길이를 저장
//		}
		adjmatrix = new int[landnum+1][landnum+1];
		for(int i=0;i<=landnum;i++) {
			Arrays.fill(adjmatrix[i], INF);
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				// 섬이라면 
				findNextLand(map[i][j],i,j);
			}
		}
		
		printAdj();
		//ckwdkTe
		
		
		
		

	}
	
	static void findNextLand(int num,int r,int c) {
		System.out.println(num);
		//해당위치에서 벽이나 다음섬, 자기땅을 만날때까지 탐색한다., 사방탐색
		for(int i=0;i<4;i++) {
			int drp = dr[i];
			int dcp = dc[i];
			int row = r;
			int col = c;
			int cnt=0;
			while(row >=0 && col >=0 && col < M && row < N && map[row][col] == 0) {
				cnt++;
				row += drp;
				col += dcp;
			}
			//무엇을 만났는지
			int next = map[row][col];
			System.out.println("next " + next);
			System.out.println(cnt);
			if(row <0 ||col <0 ||col >=M || row >= N ) continue; // 범위 초과시
			
			else if(next != num) { // 자신은 아니면서 다른땅을 만났을때
				
				if(adjmatrix[num][next] > cnt) {
					//System.out.println(cnt);
					adjmatrix[num][next] = cnt;
					adjmatrix[next][num] = cnt;
				}
			}
			
		}
		
	}
	
	
	static ArrayDeque<int[]> que =  new ArrayDeque<>();
	static void bfs(int startr,int startc) {
		landnum++;
		que.offer(new int[] {startr,startc});
		
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int r= now[0];
			int c= now[1];
			
			visit[r][c]=true;
			map[r][c] = landnum;
			
			for(int i=0;i<4;i++) {
				int row = r+dr[i];
				int col = c+dc[i];
				if(row <0 ||col <0 ||col >=M || row >= N || map[row][col]==0 || visit[row][col]) continue; //범위내에 있으면서 1이면 큐에 넣는다;
				que.offer(new int[] {row,col});
			}

		}


	}
	static void print() {
		for(int a[]: map) {
			System.out.println(Arrays.toString(a));
		}
	}
	static void printAdj() {
		for(int a[]: adjmatrix) {
			System.out.println(Arrays.toString(a));
		}
	}

}
