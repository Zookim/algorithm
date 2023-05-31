package basic.wk5;

import java.math.BigInteger;

public class Comb_DP {

	static int src = 6;
	static int tgt = 3;
	static int COUNT = 0;
	
	static int[][] dp;
	//= new int[src+1][tgt+1];
	
	public static void main(String[] args) {
	
		comb_parent_child(src,tgt);
		
		dp = new int[src+1][tgt+1];
		COUNT = comb_rc(src,tgt);
		System.out.println(COUNT);
		
		dp = new int[src+1][src+1]; // src +1 정사각형 2차원 배열
		COUNT = comb_dp(src,tgt);
		System.out.println(COUNT);

		
		
	}
	static int comb_parent_child(int n,int m) {
		int parent=1;
		int child=1;
		
		for(int i=0;i<m;i++) {
			child *= (n-i);
			parent *= (i+1);
		}
		return child/parent;
		
	}
	//nCr  6C3을 구한다.
	// 재귀호출 nCr => n-1개에서 r개 선택 + n-1개 r-1개 선택
	static int comb_rc(int src,int tgt) {

		if(src == tgt || tgt==0 ) {
			return dp[src][tgt] = 1;
		}
		if(dp[src][tgt] > 0) {
			return dp[src][tgt] ;
		}else {
			return dp[src][tgt]= comb_rc(src-1,tgt) + comb_rc(src-1,tgt-1);
		 
		}

	}
	// 파스칼삼각형 활용
	static int comb_dp(int src,int tgt) {

		dp[0][0] = 1;
		
		for (int i = 1; i <= src; i++) {
			for (int j = 0; j <= i; j++) {
				if( j ==0 || j == i) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		return dp[src][tgt];

	}
	
	
//	static int comb(int src,int tgt) {
//		
//		if(src == tgt || tgt==0 ) {
//			return dp[src][tgt] = 1;
//		}
//		if(dp[src][tgt] == 0) {
//			return dp[src][tgt] = comb(src-1,tgt) + comb(src-1,tgt-1);
//		}else {
//			return dp[src][tgt];
//		}
//		
//	}

}
