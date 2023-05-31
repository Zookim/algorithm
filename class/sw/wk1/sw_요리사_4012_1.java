package sw.wk1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_요리사_4012_1 {

	static int T, N, min;
	static int[][] map;
	static boolean [] select;
	static int[] arrA,arrB; //각각 선택된 재료의 index
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(b.readLine());
		
		for(int t =1;t<=T;t++) {
			N = Integer.parseInt(b.readLine());
			map = new int [N][N];
			select = new boolean[N];
			
			arrA = new int[N/2];
			arrB = new int[N/2];
			
			//시너지
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(b.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			//풀이
			min = Integer.MAX_VALUE;
			comb(0,0);
			System.out.println("#"+t+" "+min);
					
			
		}	
	}
	static void comb(int src,int tgt) {

		if(tgt ==N/2) {//경우의 수 완성 시 select배열에 반은 true. 반은 false인상태
			check();
			return;
		}
		if(src == N)return;
		
		select[src] =true;
		comb(src+1,tgt+1); //위 선택을 받아 들이는 것

		select[src] = false;// 선택을 받아 들이지 않았으므로 다시 false한다.
		comb(src+1,tgt);
	}
	
	static void check() {
		//그룹 A, 그룹B로 나눈다.
		//각 A는 A끼리, B는 B끼리 시너지 계산
		//두 그룹의 시너지 합의 차이가 최솟값 갱신
		int idxA = 0;
		int idxB =0;
		for (int i = 0; i < N; i++) {
			if(select[i])arrA[idxA++] = i; 
			else arrB[idxB++] = i;
		}
		//이제 시너지를 계산한다.
		int sumA =0;
		int sumB=0;
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if(i==j)continue;
				sumA += map[arrA[i]][arrA[j]];
				sumB += map[arrB[i]][arrB[j]];
			}
		}
		min = Math.min(min,Math.abs(sumA-sumB));
		
	}

}
