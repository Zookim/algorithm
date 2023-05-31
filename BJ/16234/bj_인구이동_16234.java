package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_인구이동_16234 {
	//국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다
	//위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다
	//국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다
	
	//연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
	//연합을 해체하고, 모든 국경선을 닫는다
	
	//인구 이동이 며칠 동안 발생하는지 구하는 프로그램
	// 모든 인접한나라들의 인구차이가 L 미만, R이상이 되면 국경은 더이상열리지 않는다.
	//while() -> 열린 국경의 수가 0개이면 종료한다.
	static int N,L,R;
	static int map[][];
	static boolean visit[][];
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //개의 줄
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		visit =  new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//입력 완료
		//BFS를 돌며 같은 연합에  속하는 나라들을 구한다.
		// 하루동안(while 1턴) 같은 visit를 사용한다.
		//  연합에 속한 나라의 수가 2이상일때만 값을 수정한다.
		// 모든 map을 돌면 하루가끝난다.
		
		//한번의 while을 도는 동안
		// 연합에 속한 나라의 수가 2이상인 연합이 0개 이면 종료한다. ->while문이 돈 횟수를 출력한다.
		int res=0;
		int cnt;
		while(true) {
			//visit를 초기화
			for(int i=0;i<N;i++) { //하루가 지났으므로 방문 초기화
				Arrays.fill(visit[i],false);
			}
			cnt=0;

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visit[i][j]) continue;
					else {
						if(bfs(i,j)) {
							cnt++; // 연합에 속한 나라의 수가 2이상일때만 더한다.
						}
					}
				}
			}
			if(cnt ==0) break;
			else {
				res++;
			}
			//print();
			
			
		}
		System.out.println(res);
	
		
		

	}
	static boolean bfs(int r, int c) {
		int n=0;
		int sum=0;
		ArrayDeque<int[]> que = new ArrayDeque<>();
		List<int []> list = new ArrayList<>();
		
		que.offer(new int[] {r,c});
		visit[r][c] =true;

		
		while(!que.isEmpty()) {
			
			//인접한곳을 방문하여 개방 할지를 결정하고 
			//개방하면 큐에 넣는다.
			int now[] = que.poll();
			int nr = now[0];
			int nc = now[1];
			n++;
			sum += map[nr][nc];
			list.add(new int[] {nr,nc});
			
			for(int k=0;k<4;k++) {
				int row = nr+ dr[k];
				int col = nc+ dc[k];
				if(row <0 || col <0 || row >=N||col >=N || visit[row][col]) continue;
				//개방여부 결정
				int diff = Math.abs(map[nr][nc] -  map[row][col]);
				if(diff  >= L && diff <=R) {
					que.offer(new int[] {row,col}); // 같은 연합이 된다.
					visit[row][col] = true;
					
				}
			}
			
		}
		// 연합에 속한것들의 값을 모두 수정한다.
		int data = sum / n;
		for(int a[]:list) {
			map[a[0]][a[1]] = data;
		}
		
		if(n<=1) {
			return false;
		}else {
			return true; // 2 이상이다.
		}
	}
	
	static void print() {
		for(int a[]: map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

}
