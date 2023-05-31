package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_아기상어_16236 {
	// 가장 처음에 아기 상어의 크기는 2
	//1초에 한칸씩 인접칸으로 이동

	
	
	//물고기가 없거나, 자신 보다 작은 물고기가 더이상 없을때까지 걸린시간
	static int N;
	static int map[][];
	static class Shark{
		int r,c,size = 2,eatNum =0;
		public Shark() {}
		
	}
	static Shark shark;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//현 위치에서 이동가능한 경로로(bfs) 이동했을때 가장 가까운 칸에있는 물고기에게로간다(자신보다 작은)
		shark = new Shark();
		//이동하는 거리만큼 시간을 센가.
		//조건을 만족하면 더큰 물고기도 먹을 수 있다.
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if( n==9) {
					shark.r = i;
					shark.c = j;
					n=0;
				}
				map[i][j] = n;
			}
		}
		//입력 끝
		int res;
		int result=0;
		while(true) {
			//1. bfs로 다음 이동위치를 결정한다.
			
			res = bfs(); //몇초가 흘렀는지.
			if(res == -1) {// 먹을 물고기가 없다면
				break;
			}else {
				result+=res;
			}
			
			//print();
			//System.out.println(result + " "+res);
		}
		System.out.println(result);
		
	}
	static int bfs() { //2. 이동후 상어의 상태를 변화시킨다.
		//거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
		// 같은 for 문 내메서 poll 매번 물고기의 유무를 검사하고 큐에 담아서 조건에 맞는 곳으로 간다.
		boolean visit[][] = new boolean[N][N];
		ArrayDeque<int[]> que = new ArrayDeque<>();
		PriorityQueue<int[]> pque = new PriorityQueue<>((n1,n2)->{
			return n1[0] == n2[0]? n1[1] - n2[1]: n1[0] - n2[0]; 
					}) ;
		
		
		que.offer(new int[] {shark.r,shark.c});
		visit[shark.r][shark.c] = true;
		int cnt = -1;
		
		while(!que.isEmpty()) {
			int size = que.size();
			boolean out = false;
			cnt++; //지나간 시간
			for(int s=0;s<size;s++) {
				int now[] = que.poll();
				int r = now[0];
				int c = now[1];
				int sharkSize = shark.size;
				
				if(map[r][c] < sharkSize && map[r][c] != 0) {//더 작은 물고기가 있다면, 이번 턴이 끝나고 while에서 나온다.
					pque.offer(new int[] {r,c});
					out = true;
				}
				
				//크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한
				//자신보다 작은 물고기만 먹을 수 있고, 같은 것은 지날수 있고, 큰것은 지날 수 없다
				//크기가 3이라면 3인 물고기를 3개 먹어야 4가된다.
				for(int k=0;k<4;k++) {
					int row = r+dr[k];
					int col = c+dc[k];
					
					if(row >= N || col >=N || row <0|| col <0 || visit[row][col] ||map[row][col] >sharkSize ) continue;
					//범위밖에 있고, 방문했던곳에 자기보다 큰놈이 있으면 무시 -> 아니면 경로에 넣느다.
					que.offer(new int[] {row,col});
					visit[row][col] = true;
						
				}
				
			}
			if(out) break;
			
		}//end while
		
		//이동한 위치가 있다면 cnt
		//없다면 -1
		if(pque.isEmpty()) {
			return -1;
		}else {// 먹은 물고기의 크기에 따라 상어의 크기조정, 
			int[]  next = pque.poll();

			map[next[0]][next[1]] = 0;// 사라진다.
			shark.r = next[0];
			shark.c = next[1];
			
			int n = shark.eatNum;
			if(n+1 == shark.size) {
				shark.size++;
				shark.eatNum=0;
			}else {
				shark.eatNum++;
			}

			return cnt;

		}

		
		
	}
	static void print() {
		for(int[] a: map ) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("size "+shark.size+" num"+shark.eatNum);
		//System.out.println();
	}

}
