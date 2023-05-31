package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_구슬탈출2_13460 {
	// 최소이동, 같은 방향으로 이동, 서로 겹치지 않도록 처리,장애물을 만날때 까지 이동
	
	// 최소 몇 번 만에 빨간 (R)구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램, 지나가기만 해도빠진다.
	//파란(B) 구슬이 구멍에 빠지면 실패이다. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패
	
	//기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다. , -1
	static int N,M;
	static char map[][];
	static int min = Integer.MAX_VALUE;
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray(); 
				for(int j=0;j<M;j++) {
					if(map[i][j] =='B') {
						Br = i;
						Bc = j;
						map[i][j] ='.';
					}else if(map[i][j] =='R') {
						Rr = i;
						Rc = j;
						map[i][j] ='.';
					}
				}
		}
		
		//최소동작으로 ... 
		//dfs 각 구슬의 위치를 매개변수로 넘겨주며 다음 이동위치를 결정한다. 
		// 성공, 실패, 변화 없음의 경우 해당 경우의 수를 종료한다.
		
		//BFS 각 방향으로 이동한 구슬 쌍을 저장
		//for문으로 각 턴을 구분
		
		bfs();
		
		
		
	}
	static void bfs(int Rr,int Rc, int Br, int Bc, int cnt) {
		
		map[Rr][Rc] = 'R';
		map[Br][Bc] = 'B';
		
		int RB[][] = {{Rr,Rc},{Br,Bc}};


		for(int k=0;k<4;k++) {
			//각구슬을 더이상 이동 하지 못하거나 구멍을 만날때까지 이동시킨다.
			for(int i=0;i<2;i++) {
				int r = RB[i][0];
				int c = RB[i][1];

				int rd = dr[k];
				int cd = dc[k];
				
				while(true) {
					r+= rd;
					c+= cd;
					
					if()
				}
			}
		}

		
		
	}

}
