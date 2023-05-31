package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_도영이가만든맛있는음식_2961 {

	static int N;
	static int arr[][];
	public static void main(String[] args) throws Exception  {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(4 |(1<<2));
		
	 //재료를 하나는 쓴다.
		subSet(0,0);
		System.out.println(min);
	
	}
	static int min = Integer.MAX_VALUE;
	//부분집합
	static void subSet(int index,int mask) {
		
		if(index == N) {
			if(mask ==0)return;
			//System.out.println(mask);

			int suma = 1;
			int sumb =0;
			for(int i =0;i<N;i++) {
				if((mask & (1<<i)) != 0) {
					int a = arr[i][0];
					int b = arr[i][1];
					suma *= a;
					sumb += b;
	
				}
			}
			int s =  Math.abs(suma-sumb);

			min = min > s?s: min;
			return;
		}

		
		
		subSet(index+1,mask |(1<<(index)));
		subSet(index+1,mask);
		

	}

}
