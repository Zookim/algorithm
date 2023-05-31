package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_다리놓기_1010 {
	// N개의 다리 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			dp =new BigInteger[m+1][n+1];
			for(int i=0;i<=n;i++) {
			Arrays.fill(dp[i], BigInteger.ZERO);
			}
			//long res = comb(m,n);
			BigInteger res2 = comb_c(m,n);
			//BigInteger res2 = comb_parent_child(m,n);
			//System.out.println(res);
			System.out.println(res2);
			
			
		}

	}
	static BigInteger dp[][];
	
	static BigInteger comb_c(int n,int r) {
		if(n==r || r==0) return dp[n][r] = BigInteger.ONE;
		if(dp[n][r].compareTo(BigInteger.ZERO) == 1) return dp[n][r];
	
		return dp[n][r] = comb_c(n-1,r).add(comb_c(n-1,r-1));
	}
	
	
	static long comb(int n,int r) {
		long child=1;
		long parent=1;
		
		for(int i=0;i<r;i++) {
			child *= n-i;
			parent *= i+1;
		}
		//System.out.println(child +" "+ parent);
		return child/parent;
		
	}
	
	static BigInteger comb_parent_child(int n,int r) {
		BigInteger child = BigInteger.ONE;
		BigInteger parent = BigInteger.ONE;
		
		for(int i=0;i<r;i++) {
			// 1 * n * n-1 * n-2 * ... n-m+1
			child = child.multiply(new BigInteger(String.valueOf(n-i)) ); // n-i
			parent = parent.multiply(new BigInteger( String.valueOf(i+1)) );//i+1을 곱해준다.
			
		}
		//System.out.println(child +" "+ parent);
		return child.divide(parent);
		
	}

	

}
