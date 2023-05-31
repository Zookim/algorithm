package basic.wk5;

public class 피보나치_DP {

	//1,1,2,3,5,8, ...
	public static void main(String[] args) {


		// 셋다 앞부분부터 채워나간다.
		long result = fibo_dp(50);
		
		//recursive
		//long result = fibo_rc_dp(50);
		//long result = fibo_rc(50);
		System.out.println(result);

	}
	static long fibo_rc(int n) {
		//기저조건
		if(n==1 || n==2) return 1;
		return fibo_rc(n-1) + fibo_rc(n-2);
	}
	
	static long[] memoi_rc = new long[51];
	
	static long fibo_rc_dp(int n) {
		//기저조건
		if(n==1 || n==2) return 1;
		if(memoi_rc[n] > 0) return memoi_rc[n]; //구하고자하는 재귀호출이 이미 진행되어 값을 저장해 놓았으면 그 값을 사용
		return memoi_rc[n] =  fibo_rc_dp(n-1) + fibo_rc_dp(n-2); 
		//구하고자 하는 재귀호출이 아진 진행전이면 진행하되, 그값을 저장한다.
	}

	static long[] memoi_dp = new long[51];

	static long fibo_dp(int n) { //재귀가 아닌 반복문
		memoi_dp[1] =1;
		memoi_dp[2] =1;
		
		for(int i=3;i<=n;i++) {
			memoi_dp[i] = memoi_dp[i-1] +memoi_dp[i-2];
		}
		return memoi_dp[n];
	}

}
