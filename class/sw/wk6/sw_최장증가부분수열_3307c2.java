package sw.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_최장증가부분수열_3307c2 {

	static int lis[];
	static int input[];
	static int T,N,len;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			lis = new int[N];
			input = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			//풀이
			len = 0;
			for(int i=0;i<N;i++) {
				lis[i] = 1;
				for(int j=0;j<i;j++) {
					// 마지막값(i)보다 작으면서, 지금의lis값보다 크다면 값을 변경해준다.
					if(input[j] < input[i]) {
						lis[i] = Math.max(lis[i], lis[j]+1);
					}
					
				}
				
				len = Math.max(len, lis[i]);
			}

			System.out.println("#"+test_case+" "+ len);
			
		}
		
		

	}

}
