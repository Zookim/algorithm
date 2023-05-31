package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//모르겠는데...
public class bj_평범한배낭_12865 {

	//k만큼만
	static int [][] arr;
	static int N,K;
	static boolean select[];
	static int dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		select = new boolean[N];
		arr = new int[N][2];
		dp = new int[K+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int w =  Integer.parseInt(st.nextToken());
			int v =  Integer.parseInt(st.nextToken());
			arr[i][1] = v;
			arr[i][0]  = w;
			dp[w] = dp[w] > v ? dp[w]:v;//각 무게의 최대 값이 있다.
		}
		//k==1,2이면 그냥 자기자신만남는다.
		for(int i=2;i<K/2;i++) {
			int a = ( dp[i-2]+dp[i-1]);
			dp[i] = dp[i] >a?dp[i]:a;
		}
		
		for(int i=0;i<=K/2;i++) {
			int n = dp[K-i] + dp[i];
			dp[K] = n > dp[K] ?n:dp[K];
		}
		System.out.println(dp[K]);


		
		
		
//		시간초과
//		subSet(0);
//		System.out.println(Max);

	}
	
	
	
	//부분 집합 가지치기 ->그래도 거의 모든 경우의수 확인
	static int sum=0;
	static int Weight=0;
	static int Max = Integer.MIN_VALUE;
	
	//모든 경우를 확인 ->시간초과
	
	static void subSet(int index) {
		if(Weight > K) return;
		if(index == N) {
			Max = Max > sum? Max:sum;
			return;
		}
		
		select[index] =true;
		sum +=arr[index][1];
		Weight += arr[index][0];
		subSet(index+1);
		
		//지금것을 선택하지 않는경우
		select[index] =false;
		sum -=arr[index][1];
		Weight -= arr[index][0];
		subSet(index+1);
		
		
	}

}
