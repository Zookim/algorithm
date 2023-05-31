package my.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_최소합_5188 {

	static int [][] arr;
	static int []  per;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case <= T;test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			per = new int[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					 arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

		
		}
		permutation(0,0);

	}
	static void permutation(int index, int mask) { //mask는
		if(index == N) {
			System.out.println(Arrays.toString(per));
			return;
		}
		for(int i=0;i<N;i++) {
			if((mask & (1<<i)) !=0) continue; //무시하는조건
			per[index] =i;
			permutation(index+1,(mask | 1<<i));

		}

	}

}
