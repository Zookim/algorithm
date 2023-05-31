package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;





public class BJ_구간합구하기4_11659_z {
	static int [] n_arr;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] N_M = br.readLine().split(" ");
		int N = Integer.parseInt(N_M[0]);
		int M = Integer.parseInt(N_M[1]);
		StringTokenizer sb = new StringTokenizer(br.readLine());
		n_arr = new int[N+1]; // 이후에 처음부터 합할경우 0을 이용해야한다.
		
		//n_arr[0] = Integer.parseInt(sb.nextToken());
		for(int i=1;i<=N;i++) {
			n_arr[i] = Integer.parseInt(sb.nextToken()) + n_arr[i-1]; //누적합을 넣어둔다.
		}
		//System.out.println(Arrays.toString(n_arr));
		String [][] M_arr = new String[M][2];
		for(int i=0;i<M;i++) {
			M_arr[i] = br.readLine().split(" ");
			int start = Integer.parseInt(M_arr[i][0]);
			int end = Integer.parseInt(M_arr[i][1]);
			int sum = n_arr[end] - n_arr[start-1];
//			for(int j=(start-1);j<end;j++) {
//				sum += n_arr[j];
//			}
			System.out.println(sum);
		}
		

	}

}
