package algo_live.Divide;

import java.util.Scanner;

public class DivideTest {
	
	private static int call1,call2;
	private static long exp1(long x,long n) {
		call1++;
		if(n==1) return x;
		return x*exp1(x,n-1);
	}
	
	private static long exp2(long x,long n) {
		call2++;
		if(n==1) return x;
		long y = exp2(x,n/2);
		y *=y;
		return n%2==0?y:y*x;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(exp1( x, n)+" "+call1);
		System.out.println(exp2( x, n)+" "+call2);
				
		

	}

}
