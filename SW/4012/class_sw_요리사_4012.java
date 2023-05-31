package algo.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class class_sw_요리사_4012 {

	static int arr [][];
	static int N;
	static int min;
	static int [] ans;
	static boolean [] select;
	static int count;
	static int arrA[];
	static int arrB[];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); 
			select = new boolean [N];
			arr = new int[N][N];
			arrA = new int[N/2];
			arrB = new int[N/2];
			
			
			for(int i=0;i<N;i++ ){
				st = new StringTokenizer(br.readLine());
				int j=0;
				while(st.hasMoreTokens()) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
				//System.out.println(Arrays.toString(arr[i]));
			}
			ans = new int[N/2];
			min = Integer.MAX_VALUE;
			//System.out.println(N);
			comb(0,0);
			
			System.out.println("#" + test_case+" "+min);
		}
		
	}
	
	
	static void comb(int index,int start) {
		count++;
		if(index == N/2) { 
			check();
			//System.out.println(Arrays.toString(select));
			return;
		}

		for(int i = start;i<N;i++) { 
			select[i] = true;
			comb(index+1,i+1);
			select[i] = false;
		}
		
		
	}
	static void check() {
		int indexa=0;
		int indexb=0;
		for(int i=0;i<N;i++) {
			if(select[i]) {arrA[indexa++] = i;}
			else {arrB[indexb++] = i;}
			
		}
		
		int sumA =0;
		int sumB =0;
		
		for(int i=0;i<indexa;i++) {
			for(int j=0;j<indexa;j++) {
				if(i==j)continue;
				sumA += arr[arrA[i]][arrA[j]];
				sumB += arr[arrB[i]][arrB[j]];
//				System.out.println("arrB[i] "+arrB[i]+" arrB[j] "+arrB[j]);
//				System.out.println( arr[arrA[i]][arrA[j]]);
//				System.out.println( arr[arrB[i]][arrB[j]]);
				//System.out.println(sumA +" "+sumB+" "+Math.abs(sumA-sumB));
			}
		}
		//System.out.println(sumA +" "+sumB+" "+Math.abs(sumA-sumB));
		min = Math.min(min,Math.abs(sumA-sumB));
		
		
	}

}
