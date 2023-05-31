package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_파이프옮기기1_17010 {

	// 모든 방법의 수
	//
	static int arr[][];
	static int dp[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		dp[0][2] = 1;
		dp[1][2] = 1;
		
		int res = find(N-1,N-1,2);
		
		for(int i=0;i<N;i++) {
		System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(res);

	}
	//n은 남은 거리
	//m은 직전 방향 1:오른쪽 2:대각선 아래, 3:아래로
	static int find(int r,int c,int m ) {
		//기저조건
		if(c <= 1 || r < 0 ) {
			return 0;
		}
		
		if(arr[r][c] == 1) {
			
			return dp[r][c] = 0;
		}

		if(dp[r][c] > 0) {
			return dp[r][c];
		}else {
			if(m==1) {// 오른쪽 방향으로 온 경우
				// 오른쪽으로, 대각선 아래로
				return dp[r][c] = find(r,c-1,1)+find(r-1,c-1,2);
			}else if(m==2) {// 대각선으로 온 경우
				
				return  dp[r][c] = find(r,c-1,1)+find(r-1,c-1,2)+find(r-1,c,3);
			}else if(m==3) {//위에서 내려온경우
				return dp[r][c] = find(r-1,c-1,2)+find(r-1,c,3);
			}
		}
		
		return -1;

	}

//	static int find2(int r,int c,int m ) {
//		
//		//기저
//		// 마지막에 도착하는 경우
//		
//		//오른쪽열에 인접하는 경우
//
//		//맨아래 행에 인접하는 경우
//
//
//		//벽을 만나는 경우
//		
//		//기저가 아닌 경우
//		int right=0;
//		int right_down=0;
//		int down=0;
//		//각 경우가 가능한지 확인 이전에ㅊ
//		
//		if(dp[r][c] >0) {
//			return dp[r][c];
//		}
//		
//		if(m==1) {
//			// 오른쪽으로, 대각선 아래로
//			return dp[r][c] = find(r,c+1,1)+find(r+1,c+1,2);
//		}else if(m==2) {
//			return  dp[r][c] = find(r,c+1,1)+find(r+1,c+1,2)+find(r+1,c,3);
//		}else if(m==3) {
//			return dp[r][c] = find(r+1,c+1,2)+find(r+1,c,3);
//		}
//		
//		
//		
//		
//		
//	}

}
