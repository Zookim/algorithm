package algo.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class bj_스타트와링크_14889 {
	static int [] arrA;
	static int [] arrB;
	static int N;
	static int [][] arr;
	static int min = Integer.MAX_VALUE;
	static int count;
	static int out=1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(b.readLine());
		arr = new int[N][N];
		boolean select[] = new boolean[N];
		
		arrA = new int[N/2];
		arrB = new int[N/2];
		
		int u=1;
		int d=1;
		for(int i=0;i <N/2;i++) {
			 u *= (N-i);
			 d *= (N/2-i);
		}
		out = u/d;
		
		
		
		for(int i = 0; i< N;i++) {
			st = new StringTokenizer(b.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			//System.out.println(Arrays.toString(arr[i]));
			
		}
		
		comb(0,0,select);
		System.out.println(min);
		//System.out.println(out);
		
		
		
		

	}
	static void comb(int index,int start,boolean [] select) {
		if(count == (out/2)) {//System.out.println(out/2); //왜 일렇게하면 오답 ??
			return;}
		if(index == N/2) {
			count++;
			check(select);
			return;
		}
		for(int i=start;i<N; i++) {
			select[i] = true;
			comb(index+1,i+1,select);
			select[i] = false;
		}
	}
	
	static void check(boolean [] select) {
		int aindex=0;
		int bindex=0;
		
		int sumA=0;
		int sumB=0;
		for(int i =0;i<N;i++) {
			if(select[i]) arrA[aindex++] = i;
			else{arrB[bindex++] = i;}
		}
		//System.out.println(Arrays.toString(arrA));
		//System.out.println(Arrays.toString(arrB));
		//System.out.println();
		
		
		for (int i = 0; i < aindex; i++) {
			for (int j = 0; j < aindex; j++) {
				if(i==j) continue;
				sumA += arr[arrA[i]][arrA[j]];
				//System.out.print("A "+arr[arrA[i]][arrA[j]]+ " ");
				sumB += arr[arrB[i]][arrB[j]];
				//System.out.println("B " + arr[arrB[i]][arrB[j]]);
			}
		}
		
		int m = Math.abs(sumA-sumB);
		//System.out.println("count "+count +" "+m);
		min = min < m ? min :m;
		
		
	}

}
