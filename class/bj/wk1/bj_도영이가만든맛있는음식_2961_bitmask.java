package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_도영이가만든맛있는음식_2961_bitmask {

	static int N;
	static boolean[] select;
	static int [][] src;
	static int min; //
	public static void main(String[] args) throws Exception {

		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(b.readLine());
		min = Integer.MAX_VALUE;
		src = new int[N][2];
		int mask=0;
		
		StringTokenizer st;
		for(int test_case = 0; test_case <N;test_case++) {
			
			st = new StringTokenizer(b.readLine());
			src[test_case][0] = Integer.parseInt(st.nextToken());
			src[test_case][1] = Integer.parseInt(st.nextToken());
			
		}
	

		subset(0,mask);
		System.out.println(min);
		

	}
	static void subset(int index,int mask) {
		
		if(index == N ) {
			int sin =1;
			int ssn=0;
			int cnt=0;
			
			for (int i = 0; i < N; i++) {
				if(select[i]) {
				sin *= src[i][0];
				ssn += src[i][1];
				cnt++;
				}
			}
			if(cnt >0) {
				min = Math.min(min, Math.abs(sin-ssn));
				
			}

			return;
		}
		select[index] =true;
		subset(index+1,mask |1 << index);
		select[index] =false;
		subset(index+1,mask);
		
		
	}


}
