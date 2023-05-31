package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_평범한배낭_12865_c {

	//1차원 배열을 이동
	// 큰 무게 부터 고려한다.
	//물건을 하나씩만 사용할수 있다는 제한이 있으므로, 
	// 큼무게 부터 고려해야한다.
	
	// 2차원 배열의 경우 max비교를 할때 현재 물건이 담기지 않은 경우를 이전행을 통해 참조할수 있다.
	//하지만 일차원의 경우 이전값은 현재물건을 담은 상태일수 있으므로 안된다.
//	 4 7
//	 
//	 6 13 : 7 -> 6 
//	 4 8 : 7 -> 6 -> 5 -> 4
//	 
//	 3 6 : 7 -> 6 -> 5 -> 4 -> 3 -> m[7] = Max(13, m[7-4]+6), m[6] = 13, m[5] = 8, m[4] =8 ,m[3] =6
//	 5 12
//	
	// 2차원 보다 훨 좋다.
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[] = new int [K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=K;j >= w ;j--) { //무게
				dp[j] = Math.max(dp[j], dp[j-w] +v);
				
			}
		}
		
		System.out.println(dp[K]);
	}

}
