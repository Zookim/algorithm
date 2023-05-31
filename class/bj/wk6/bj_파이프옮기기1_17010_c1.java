package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//완전 탐색
public class bj_파이프옮기기1_17010_c1 {

	// 모든 방법의 수
	//
	static int map[][];
	static int N, cnt;
	static int [][][] delta = {
			{ {1,1},{0,1},{1,0} }, //대각선 : 0=> 대각선, 가로, 세로
			{ {1,1},{0,1},{0,0} }, //가로 : 1 => 대각선 가로 , 세로(dummy)
			{ {1,1},{0,0},{1,0} } //세로 : 2 => 대각선 , 가로(dummy), 세로
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i = 1;i <= N;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1;j <= N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1,2,1);
		System.out.println(cnt);

	}
	static void dfs(int y, int x, int d) {//
		//마지막에 도달하게되면  카운트한다.
		if(y == N && x == N) {
			cnt++;
			return;
		}
		
		for(int i=0;i<3;i++) {
			int ny = y+ delta[d][i][0];
			int nx = x+ delta[d][i][1];
			
			if(ny==y && nx ==x) continue; //dummy 확인
			
			//갈수 없는 곳
			if(ny > N || nx > N ||map[ny][nx] ==1 ) continue;
			
			//대각선으로 이동하는 경우 벽이 있는지 확인
			if(i ==0 && (map[ny][nx-1] ==1 || map[ny-1][nx] ==1)) continue;
			
			
			//이동한다
			dfs(ny, nx,i);
		}
	}
}
