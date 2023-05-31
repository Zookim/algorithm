package algo.wk9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_RGB거리_1149 {

	static int  dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		dp = new int [N+1][3];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+Integer.parseInt(st.nextToken());
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+Integer.parseInt(st.nextToken());
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+Integer.parseInt(st.nextToken());
			
		}
		
		int res = (dp[N][0] < dp[N][1]) ? (dp[N][0] <dp[N][2] ?dp[N][0]:dp[N][2] ) :dp[N][1];

		System.out.println(res);
	}

}