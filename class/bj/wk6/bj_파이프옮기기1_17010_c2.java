package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//dp
public class bj_파이프옮기기1_17010_c2 {

	// 모든 방법의 수
		//
		static int arr[][];
		static int dp[][][];
		static int N;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1][N+1];
			dp = new int [3][N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=1;j<=N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			
			dp[1][1][2] = 1; //시작위치에서 가로로 시작하므로
			
			
			for(int i=1;i<=N;i++) {//행
				for(int j=2;j<=N;j++) {
					
					//대각선으로 이동한다
					//이동한 후의 값이 범위내에 있어야하고, 다음위치와 대각선부분에 벽이 없어야한다.
					if(j+1 <=N && i+1<=N && arr[i+1][j] ==0 && arr[i][j+1] ==0 && arr[i+1][j+1]==0) {
						 dp[0][i+1][j+1] += dp[0][i][j] + dp[1][i][j] + dp[2][i][j];
						 // 현재 위치로 온 방법 중에서 모두 가능
			
					}
					//가로로 이동한다
					if(j+1 <=N && arr[i][j+1] ==0) {
						 dp[1][i][j+1] += dp[0][i][j]+dp[1][i][j];
						 // 현재 위치에서 가로 였으니 가로와 대각선으로 이동한다.
					}
					//세로로 이동한다
					if( i+1<=N && arr[i+1][j] ==0) {
						 dp[2][i+1][j] += dp[0][i][j]+dp[2][i][j];
						//세로로 이동하므로 세로로 온것과 대각선으로 온것을 넘겨준다.
					}
					
				}
			}
			
			
			int res = dp[0][N][N] + dp[1][N][N] + dp[2][N][N];
	
			System.out.println(res);

		}
		
}
