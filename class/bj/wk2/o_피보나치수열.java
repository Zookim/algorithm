package bj.wk2;

import java.util.Scanner;

public class o_피보나치수열 {

	static long arr[];
	public static void main(String[] args) {
		int n =50; //50번째
		arr =  new long[n+1];
//		
//		long res1 = fibo(n);
//		System.out.println(res1);
//		
//		long res2 = fibo_dp(n);
//		System.out.println(res2);
		
		long res3 = fibo2_memoi(n);
		System.out.println(res3);

	}
	static long fibo2(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibo(n-1)+fibo(n-2);
	}
	
	
	static long[] memoi_rc = new long[51];
	static long fibo2_memoi(int n) { // 메모이제이션, dp
		if(n==0) return 0;
		if(n==1) return 1;
		
		if(memoi_rc[n]>0) return memoi_rc[n];
		else return memoi_rc[n] = fibo2_memoi(n-1) +fibo2_memoi(n-2) ;

	}
	
	static long fibo(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibo(n-1)+fibo(n-2);
	}
	static long fibo_dp(int n) {
		arr[0] =0;
		arr[1]=1;
		
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		return arr[n];
	}
}
