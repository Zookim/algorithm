package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj_적록색약_10026_c {
	//2.dfs 함수를 다르게 적용하는 경우
	//틀린코드
	//G,R
	//상하좌우
	static char arr[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N,cnt,cnt2;
	static boolean[][] visit,visit2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//같으면 수를 같은수로...
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		visit = new boolean [N][N];
		visit2 = new boolean [N][N];
		
		
		//
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					cnt++;
				}
				if(!visit2[i][j]) {
					dfs2(i,j);
					cnt2++;
				}
				
			}
		}
		
		
		System.out.println(cnt + " "+cnt2);

	}
	static void dfs(int r,int c) {
		visit[r][c] =true;
		
		for(int d=0;d<4;d++) {
			int row = r+dr[d];
			int col = c+dc[d];
			                                                          // 서로 다른 문자인 경우
			if(row <0 || row >=N||col<0||col>=N||visit[row][col]|| arr[r][c] != arr[col][row]) continue;
			dfs(row,col);
		}
		
	}
	static void dfs2(int r,int c) {
		visit2[r][c] =true;
		
		for(int d=0;d<4;d++) {
			int row = r+dr[d];
			int col = c+dc[d];
			
			if(row <0 || row >=N||col<0||col>=N||visit2[row][col]) continue;
			// G,R -> G,R
			//B->B 여야한다
			//시작이 같으면 계속 같은 곳으로 가므로
			if((arr[r][c] == 'R' || arr[r][c] == 'G') && (arr[row][col] == 'R' || arr[row][col] == 'G') ) {
				dfs2(row,col);
			}
			else if(arr[r][c] ==  arr[row][col]) {
				dfs2(row,col);
			}
		}
		
	}
	
}
