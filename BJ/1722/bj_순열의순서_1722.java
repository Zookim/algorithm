package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_순열의순서_1722 {

	static long K;
	static int N;
	static boolean [] select ;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(b.readLine());
		sb = new StringBuilder();
		
		StringTokenizer st =  new StringTokenizer(b.readLine());
		select = new boolean [N];
		
		if(st.nextToken().equals("1")) { //K번째 순열 구하기
			K = Long.parseLong(st.nextToken())-1;
			perm(0);
			System.out.println(sb);
		}else { //해당 순열의 순서구하기
			long sum=0;
			for(int i=0;i<N;i++) {
				int now = Integer.parseInt(st.nextToken())-1;
				long count=0;
				for(int j=0;j<N;j++) {
					if(select[j])continue;
					if(j == now) {
						sum += fact(N-i-1)*count;
						select[now] = true;
					}
					count++;
				}
				
			}
			System.out.println(sum+1);
		}

	}
	static void perm(int index) {
		
		if(index == N) {
			return;
		}
		long f = fact(N-index-1);
		long a = K/f;
		
		int count=0;
		for(int i=0;i<N;i++) {
			if(select[i]) continue;
			if(count == a) {
				select[i] = true;
				sb.append(i+1).append(" ");
				break;
			}
			count++;
			
		} 
		K = K%f;
		perm(index+1);
		
		
		
	}
	static long fact(int n) {
		long sum =1;
		for(int i=1;i<=n;i++) {
			sum *= i;
		}
		return sum;
	}

}
