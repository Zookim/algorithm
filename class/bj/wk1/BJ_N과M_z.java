package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_N과M_z {

	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		String [] arr = b.readLine().split(" ");
		
		// N 까지 M 개
		int [] ans = new int [Integer.parseInt(arr[1])];
		boolean select[] = new boolean[Integer.parseInt(arr[0])]; 
		
		//1 3
		perm(Integer.parseInt(arr[1]),ans,Integer.parseInt(arr[0]),select);
		
		
		
		

	}

	static void perm(int N, int [] ans,int M, boolean [] select) {
		//System.out.println(N);
		if(N ==0) {System.out.println(Arrays.toString(ans));return;}
		else {
			
			for(int i=0;i<M;i++) {
				if(select[i])continue;
				ans[N-1] =i+1;
				select[i] = true;
				perm(N-1,ans,M,select);
				select[i] = false;
			}
			
		}
	}

}
