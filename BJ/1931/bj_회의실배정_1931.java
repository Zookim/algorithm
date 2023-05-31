package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_회의실배정_1931 {
//k원을 만드는데 필요한 동전의 최소 수
	static int [][] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		
		arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,(n1,n2) ->{ return n1[1]==n2[1] ?n1[0]-n2[0] :n1[1] - n2[1];});
		
		int count =1;
		int end = arr[0][1];

		
		for(int i=1;i<N;i++) {
			if(arr[i][0] >= end ) {
				count++;
				end = arr[i][1];
			}
		}
		System.out.println(count);
		
	}

}
