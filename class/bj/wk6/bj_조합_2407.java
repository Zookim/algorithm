package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class bj_조합_2407 {

	static long [][]memoi;
	public static void main(String[] args) throws IOException {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		BigInteger child = BigInteger.ONE;
		BigInteger parent = BigInteger.ONE;
		
		for(int i=0;i<m;i++) {
			// 1 * n * n-1 * n-2 * ... n-m+1
			child = child.multiply(new BigInteger(String.valueOf(n-i)) ); // n-i
			parent = parent.multiply(new BigInteger( String.valueOf(i+1)) );//i+1을 곱해준다.
			
		}
		
		System.out.println(child.divide(parent));
		
//		
//		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
//		String arr[] = br.readLine().split(" ");
//		
//		int n = Integer.parseInt(arr[0]);
//		int m = Integer.parseInt(arr[1]);
//		memoi = new long[n+1][m+1];
//		
//		long res = comb(n,m);
//		System.out.println(res);
//		
	}
	
	static long comb(int n,int m) {
		
		if(n==m || m==0) {
			return 1;
		}
		if(memoi[n][m] != 0 ) {
			return memoi[n][m];
		}
		return memoi[n][m] = comb(n-1,m)+ comb(n-1,m-1);

	}
	
	
}
