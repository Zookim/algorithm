package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_N과M {
	// static 을 맨위에 두지 않는다.
	static int N,M;
	static int[] src,tgt;
	static boolean[] select;
	

	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N+1];
		select = new boolean[N+1];
		tgt = new int[M];
		
		for(int i=1;i<=N; i++) {
			src[i]=i;
		}
		
		perm(0);
	

	}

	static void perm(int tgtIdx) {
		//System.out.println(N);
		if(tgtIdx == M) {
			for(int n: tgt) {
				System.out.println(n+" ");
			}
			System.out.println();
			return;
		}
		
		else {
			
			for(int i=0;i<M;i++) {
				if(select[i])continue;
				
				tgt[N-1] =i+1;
				select[i] = true;
				perm(tgtIdx+1);
				select[i] = false;
			}
			
		}
	}

}
