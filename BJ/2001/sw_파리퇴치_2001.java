package algo.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_파리퇴치_2001 {

	static int arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));


		int T = Integer.parseInt(b.readLine());
		StringTokenizer st;
		for(int test_case =1;test_case <= T;test_case++) {
			st = new StringTokenizer(b.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr= new int[N+1][N+1];
			//System.out.println(Arrays.toString(arr[0]));
			
			for(int i=1;i<=N;i++) { //첫자리 연산을 위해 여백을 남겨둔다. 왼쪽과 위쪽에 여백
				st = new StringTokenizer(b.readLine());
				for(int j=1;j<=N;j++) {
					arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + Integer.parseInt(st.nextToken());
					//System.out.println(arr[i][j]);
				}
			}
			
			//최대 값 구하기
			int sum = 0;
			int max=0;
			
			for(int i=M;i<=N;i++) {
				for(int j=M;j<=N;j++) {
					sum = arr[i][j] - arr[i-M][j] - arr[i][j-M] +arr[i-M][j-M];
					max = sum < max ? max:sum;
				}
				
			}
			System.out.println("#" + test_case+" "+max);
			
			
		}

	}

}
