package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1학년_5557 {

	static int [] arr;
	static int N;
	static long res;//등식의 수
	static long dp[][];
	static int range =21; //0 에서 20사이의 수, 이 범위가 주어진것도 중요
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		
		dp = new long[N][range];
		
		StringTokenizer st =new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		dp[0][arr[0]]++;//당연히 범위 내에 있다.
		for(int i=1;i<(N-1);i++) {
			for(int j=0;j<range;j++) {
				if(dp[i-1][j] != 0) { //직전의 것만 고려한다.//현재끼리 합하고, 이전것은 곱한다.
					if(j+arr[i] <=20) {dp[i][j+arr[i]] += dp[i-1][j];}
					//범위내에 있을 때
					if(j-arr[i]>=0) {dp[i][j-arr[i]] += dp[i-1][j];}
					//j+arr[i] : 이전 값에 현재값을 더해본다.
				}
				
			}
		}
		res = dp[N-2][arr[N-1]];
		
		System.out.println(res);

	}

}
