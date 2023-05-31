package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_도영이가만든맛있는음식_2961_z {

	static int T;
	static int [] ans;
	static int [] arr;
	static int min = 1000; //
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// N개의 재료
		// S는 곱, B는 합 : 이들의 차이를 적게 만든다, 공집함은 뺀다.
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(b.readLine());
		
		arr = new int[T*2];
		StringTokenizer st;
		for(int test_case = 0; test_case <T;test_case++) {
			st = new StringTokenizer(b.readLine());
			arr[test_case] = Integer.parseInt(st.nextToken());
			arr[test_case+T] = Integer.parseInt(st.nextToken());
			
		}
		//ans = new int[T];

		subset(0,0);
		

	}
	static void subset(int index, int mask) {
		
		if(index == T*2 ) {
			printsubset(mask);
			return;
		}
		
		subset(index+1,mask | 1 <<index);
		subset(index+1,mask);
		
		
	}
	static void printsubset(int mask) {
		int Bsum =0; 
		int Ssum =0; 
		for(int i=0;i<T*2;i++) {
			if((mask & 1 <<i) !=0) {
				if(i >= T) {Bsum += arr[i];}
				else {Ssum = Ssum * arr[i];}
				
			}
		}
		min = Math.abs(Bsum-Ssum);
		
	}

}
