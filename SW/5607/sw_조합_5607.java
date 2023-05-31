package algo.wk9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//4_6과제
public class sw_조합_5607 {
	static final long m = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			//n까지 패토리얼을 구하며 MOD 연산한다.
			long fac[] = new long[N+1]; //dummy
			fac[0] = 1; //초기값
			for(int i=1; i<=N;i++) {
				fac[i] = (fac[i-1]*i ) % m;
			}
			long b = (fac[R] * fac[N-R]) %m;
			long res = (fac[N] * make(b, m-2)) % m;
			System.out.println("#"+test+" "+res);
		}
	}
	static long make(long b,long p) {
		if(p==0) return 1;//기저 조건
		long tmp = make(b,p/2); // 기저가 될때까지 나누고, %연산을 하며 올라오온다.
		long res = (tmp * tmp) % m;
		if(p % 2 ==0) return res;//짝수라면 그대로
		else return( res*b )%m;// 홀수라면 하나더 곲한다.
		//
		
		
	}

}
