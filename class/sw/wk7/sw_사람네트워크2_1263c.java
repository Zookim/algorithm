package sw.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_사람네트워크2_1263c {
	static int matrix[][];
	static int T,N;
	static final int INF = 9999999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case <= T;test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int n=Integer.parseInt(st.nextToken());
					if( i != j && n==0) matrix[i][j] = INF;
					else matrix[i][j] = n;
				}
			}
			
			// 입력
			for(int k=0;k<N;k++) { // 모든 경로를 포함해보면서
				
				for (int i = 0; i <N; i++) { // 출발점
					if(i==k) continue;
					for (int j = 0; j <N; j++) { // 도착점
						if(i==j || k==j) continue;
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+ matrix[k][j]);
						
					}
				}
				
			}
			//matrix 완성, 이중에서 최소값을 구한다.
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum=0;
				for(int j=0;j<N;j++) {
					sum += matrix[i][j];
					
				}
				min = Math.min(min, sum);
			}
			
			System.out.println("#"+test_case+" "+min);

		}

	}

}
