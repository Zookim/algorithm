package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;





public class BJ_구간합구하기4_11660_2 {

	
	static int N,M;
	static int [][] accu;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb = new StringTokenizer(br.readLine());
		//String[] N_M = br.readLine().split(" ");
		int N = Integer.parseInt(sb.nextToken());
		int M = Integer.parseInt(sb.nextToken());
		
		
		accu = new int[N+1][N+1];
		

		for(int i=1;i<=N;i++) {
			sb = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				accu[i][j] = accu[i-1][j] + accu[i][j-1]-accu[i-1][j-1] +Integer.parseInt(sb.nextToken()); // 행별 누적합을 기롭
			}
		}

		// M개의 입력을 처리
		StringBuilder st = new StringBuilder();
		for(int i=0;i<M;i++) {
			sb = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(sb.nextToken());
			int y1 = Integer.parseInt(sb.nextToken());
			int x2 = Integer.parseInt(sb.nextToken());
			int y2 = Integer.parseInt(sb.nextToken());
//			int sum=0;
//			for (int x=x1;x<=x2;x++) {
//				sum += accu[x][y2] - accu[x][y1-1];
//			}
			int sum = accu[x2][y2] - accu[x1-1][y2] - accu[x2][y1-1] + accu[x1-1][y1-1];
			st.append(sum).append("\n");
			
			
		}
		System.out.println(st);
		

	}

}
