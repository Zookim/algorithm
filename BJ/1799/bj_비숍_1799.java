package algo.wk11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_비숍_1799 {
//놓을수 있는 최대 비숍의 크기
	static int map[][];
	static int N;
	static int maxs=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) { //1이 둘수 있는 곳
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//모든 경우를 돌며 최대값을 구한다.
		//대각선을 검사한다.
		dfs(0,0,0);

	}
	static void dfs(int r, int c,int num) {
		
		while(true) {
			if(map[r][c] == 1) {
				//1 이면 0으로 만들고 대각선들도 0으로 만든다 갯수를 센다
				check(r,c);//대각선 체크
				dfs(r,c,num+1);
				uncheck(r,c);//대각선 체크해제
			}
			//0이면 1이 나올때까지 찾는다.
			//맵이 끝나고 최대값이면 갱신한다.
			c++;
			if(c == N) {r++;c=0;}
			if(r == N) {
				maxs = maxs < num? num:maxs;
				return;
			}


			
		}
		
		
	}
	static void check(int r, int c) {
		//자신과 대각선을 체크한다.
		map[r][c] =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					map[i][j]=2;
				}
			}
		}
	}

}
