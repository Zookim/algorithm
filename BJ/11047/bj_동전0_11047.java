package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_동전0_11047 {
//k원을 만드는데 필요한 동전의 최소 수
	static int [] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=N-1;i>=0;i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int res=0;
		for(int i=0;i<N;i++) {
			int a=arr[i];
			if(a <= K) {
				res += K / a;
				K = K % a;
			}
		}
		System.out.println(res);
		

	}

}
