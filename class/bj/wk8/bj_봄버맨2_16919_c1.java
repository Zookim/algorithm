package bj.wk8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_봄버맨2_16919_c1 {
// 모든칸이 터지는 경우
	static int map[][];
	static int R,C,N;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	static int EMPTY = -9; //.대신 사용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i <R; i++) {
			char[] temp = br.readLine().toCharArray();
			
			for (int j = 0; j <C; j++) {
				map[i][j] = temp[j] == '.' ?EMPTY:0;
			}
		}
		// N값에 따라 다르게 처리
		if(N==1) { 
			
			outprint();
		}else if(N%2==0) {
			outprint1();
			//여기까지 맵에 대한 작업이 없다
		}else {
			N = N%4+4;
			//System.out.println("Sdf");
			for (int t = 2; t <= N ; t++) {
				//짝수 초: 폰탄설치, 홀수 초: 폭탄 폭발
				if(t % 2==0) putBomb(t);
				else explodeBomb(t);
			}
			outprint();
		}
		
		System.out.println(sb);

	}
	static void putBomb(int time) {
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				if(map[i][j] == EMPTY) map[i][j] = time; //시간 기록
			}
		}
	}
	static void explodeBomb(int time) {
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				int now = time -3; //설치후 3초가 지낭 폭탄
				
				if(map[i][j] != now) continue;
				
				map[i][j] = EMPTY;
				
				//주변도 같이 폭발
				for(int d=0;d<4;d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					
					if(nr <0 || nc <0 || nr >=R|| nc >=C) continue;
					if(map[nr][nc] != now) map[nr][nc] = EMPTY; //!= EMPTY를 폭발 시키면 안되고, !=now를 폭발시켜야한다.
				}
				
			}
		}
	}
	
	static void outprint() {

		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				sb.append(map[i][j] == EMPTY ? '.':'O');
			}
			sb.append("\n");
		}
		

	}

	static void outprint1() {

		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				sb.append('O');
			}
			sb.append("\n");
		}


	}



}
