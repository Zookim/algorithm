package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_평범한배낭_12865 {

	//가치의 최대값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[][] = new int [N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=1;j<=K;j++) { //무게
				//배낭에 넣을 수 없다면 이전값을 받아오고
				if(j<w) {
					dp[i][j] = dp[i-1][j];
				}else {// 넣을 수 있다면 넣었을때와 넣지 않았을때의 가치를 비교해 큰가치를 저장한다.
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v);
				}
				
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
