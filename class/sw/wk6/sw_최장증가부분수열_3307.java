package sw.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_최장증가부분수열_3307 {

	static int lis[];
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			lis = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				
				arr[i] = Integer.parseInt(st.nextToken());
				
				
			}
			
			//입력
			int max = 0;
			for(int i=0;i<n;i++) {
				lis[i] = 1;
				for(int j=0;j<i;j++) {
					// 마지막값(i)보다 작으면서, 지금의lis값보다 크다면 값을 변경해준다.
					if(arr[i] > arr[j] && lis[j] >= lis[i]) {
						lis[i] = lis[j] +1;
					}
					
				}
				
				max = (max < lis[i]) ? lis[i]:max;
			}
			
			//System.out.println(Arrays.toString(lis));
			System.out.println("#"+test_case+" "+ max);
			
		}
		
		

	}

}
