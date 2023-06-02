package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_최솟값과최댓값_2357 {
	//시간초과
	public static void main(String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			int start = Integer.parseInt(st.nextToken()) - 1 ;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			for(int j = start ; j <= end ; j++) {
				int now = arr[j];
				min = (min > now) ? now: min;
				max = (max < now) ? now : max;
			}
			sb.append(min).append(" ").append(max).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
