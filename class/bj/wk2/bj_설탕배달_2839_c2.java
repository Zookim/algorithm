package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_설탕배달_2839_c2 {

	
	static int[] dp;
	public static void main(String[] args) throws Exception{
		//3,5 ...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		int count=0;
		int N = Integer.parseInt(br.readLine());

		if(N <=5) {
			if(N==3|| N==5)System.out.println(1);
			else System.out.println(-1);
			return;
		}
		dp = new int[N+1];
		//봉투를 최소로 사용
		// N kg을 만들어가는 과정에서 3kg 봉투 또는 5kg 봉투를 사용
		// 이 때 최소 비용이 무엇인지 판단해서 사용
		Arrays.fill(dp,5000);
		
		dp[3] =1; //3kg울 배달하는데 1봉지를 사용했다. 
		dp[5] =1; //5kg을 사용하는데 1봉지를 사용했다.
		
		for(int i=6; i<= N;i++) {
			dp[i] = Math.min(dp[i-3]+1,dp[i-5]+1); //좀더 싼 값을 가져간다.
		}
		
		if(dp[N] > 5000) System.out.println(-1);
		else System.out.println(dp[N]);
	//	System.out.println(dp[N]);
	}

}
