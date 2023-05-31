package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;





public class BJ_구간합구하기4_11659 {

	
	static int N,M;
	static int [] accu;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb = new StringTokenizer(br.readLine());
		//String[] N_M = br.readLine().split(" ");
		int N = Integer.parseInt(sb.nextToken());
		int M = Integer.parseInt(sb.nextToken());
		
		
		accu = new int[N+1];
		sb = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			//System.out.println(sb.nextToken());
			accu[i] = Integer.parseInt(sb.nextToken()) + accu[i-1]; //누적합을 기롭
			//System.out.println(Arrays.toString(accu));
		}
		
		// M개의 입력을 처리
		StringBuilder st = new StringBuilder();
		for(int i=0;i<M;i++) {
			sb = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(sb.nextToken());
			int end = Integer.parseInt(sb.nextToken());
			st.append(accu[end]-accu[start-1]).append("\n");
			
			
		}
		System.out.println(st);
		

	}

}
