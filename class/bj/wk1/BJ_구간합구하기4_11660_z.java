package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;





public class BJ_구간합구하기4_11660_z {
	static int [] n_arr;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb = new StringTokenizer(br.readLine());
		

		int N = Integer.parseInt(sb.nextToken());
		int M = Integer.parseInt(sb.nextToken());
		
		n_arr = new int[N*N+1]; // 처음부터 합할경우를 따로 생각한다.
		

		for(int i=0;i<N;i++) {
			sb = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				n_arr[i*N+j+1] = Integer.parseInt(sb.nextToken()) + n_arr[i*N+j]; 
			}
		}
		System.out.println(Arrays.toString(n_arr));
		
		for(int j=0;j<M;j++) {
			int arr [] = new int [4];
			sb = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				arr[i] = (Integer.parseInt(sb.nextToken())-1);
				//System.out.println(arr[i]);
			}

			int start = arr[0]*N + arr[1]+1;
			int end = arr[2]*N + arr[3]+1;
			
			System.out.println(n_arr[start]);
			System.out.println(n_arr[end]);
			System.out.println(n_arr[end]-n_arr[start]);
		}


	}

}
