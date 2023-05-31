package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_로봇청소기_14503 {
//로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수
	
	//청소기
	//소기는 바라보는 방향이 있으며, 청소기가 있는 곳은 항상 빈칸
	//상: 0,하: 2,좌: 3,우: 1(시계방향)
	
	//4칸 중 청소되지 않은 빈 칸이 없는 경우
	//바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다
	//바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다
	
	
	//청소되지 않은 빈칸이 있는 경우
	//반시계 방향으로 90도 회전한다.
//	바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
//	1번으로 돌아간다.
	
	//벽 : 1, 청소해야할곳 :0
	static int N,M,startr,startc,d;
	static int map[][];
	static boolean clean[][];
	//상: 0,하: 2,좌: 3,우: 1(시계방향)
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		clean = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		startr = Integer.parseInt(st.nextToken());
		startc = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//청소하는 칸의 수는?
		int nowr = startr;
		int nowc = startc;
		int count=0;
		while(true) {
			//System.out.println("r "+nowr+" c "+nowc+" d "+d );
			//현재 위치가 청소되지 않았으면 청소한다.
			if(clean[nowr][nowc] == false) {
				clean[nowr][nowc] = true;
				count++;
			}
			//다음으로 선택할 곳을 찾는다.(범위내, 빈칸 여부,clean)
			int c=0;
			for (int i = 0; i < 4; i++) {
				int row = nowr+dr[i];
				int col = nowc+dc[i];
				if(row >= N || row <0|| col >= M||col <0 || map[row][col] == 1 || clean[row][col] )continue;
				c++;
			}
			//1. 있다 -> 한번만회전해 본다. 전진한다.
			if(c>0) {
				if(--d<0) d=3;
				//d의 방향에 청소하지 않은 것이 있다.
				int row = nowr + dr[d];
				int col = nowc + dc[d];
				if(row < N && row >= 0 && col < M&&col >=0 && map[row][col] == 0 && !clean[row][col] ) {
					nowr = row;
					nowc = col;
				}//아니면 일단 그냥 1로 돌아간다.
				
			}
			else{//2. 없다.-> 후진한다., 할수없다.break
				nowr = nowr - dr[d];
				nowc = nowc - dc[d];
				//System.out.println("r "+nowr+" c "+nowc+" d "+d );
				if(map[nowr][nowc] == 1) break;
			}
			
			
		}
		System.out.println(count);
		
	}

}
