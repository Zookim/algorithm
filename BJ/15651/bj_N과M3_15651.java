package my.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_N과M3_15651 {
//중복조합
	static int N,M;
	static boolean select[];
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder ans = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		select = new boolean[N+1];
		arr = new int[N];
		perm(0);
		
		System.out.println(ans);

	}
	//1.재귀
	static void perm(int index) {
		if(index == M) {
			ans.append(sb).append("\n"); //여기서 일일이 하면 시간초과
			
			return;}
		
		for(int i=1;i<=N;i++) {

		
			sb.append(i).append(" ");
			perm(index+1);
			
			sb.setLength(sb.length()-2);
		
		}
		
	}

}
