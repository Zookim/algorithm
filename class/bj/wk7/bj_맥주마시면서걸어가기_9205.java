package bj.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_맥주마시면서걸어가기_9205 {
	// 50 미터에 한병씩, 편의점에서 최대 20개
	//집, 편의점, 페스티벌
	// 한번에 최대 20개씩만 
	
	static int T,N,V;
	static int Big = 101*32767*2;
	static int[][] matrix,input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T;test_case++ ) {
			N =  Integer.parseInt(br.readLine());
			V = N+2;
			input = new int[V][2];
			matrix = new int[V][V];
			
			//입력
			for(int i=0;i<V;i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0] =  Integer.parseInt(st.nextToken());
				input[i][1] =  Integer.parseInt(st.nextToken());
			}
			//matrix 구성
			//int min = Integer.MAX_VALUE;
			for(int i=0;i<V;i++) { // 
				int vy = input[i][0];
				int vx = input[i][1];
				
				for (int j = 0; j < V; j++) {
					if(i==j)continue;
					
					int ty = input[j][0];
					int tx = input[j][1];
					int dis = Math.abs(ty - vy) +  Math.abs(tx - vx);// 맨하탄거리로 계산
					
					if( dis <= 1000) matrix[i][j] = dis; // 비용으로 연결
					else matrix[i][j] = Big;
			
				}
			}
			
			//플로이드 워셜적용
			for(int k=0;k<V;k++) { //경유지
				for(int i=0;i<V;i++) {
					if(i==k) continue;
					for(int j=0;j<V;j++) {
						if(j==i||j==k) continue;
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
				
			}
			
			
			// (집: 0 ) -> (공연장: V-1) matrix[0][V-1] Big가 아니면 happy or sad
			System.out.println(matrix[0][V-1] < Big ? "happy" : "sad");
		}
	}
}
