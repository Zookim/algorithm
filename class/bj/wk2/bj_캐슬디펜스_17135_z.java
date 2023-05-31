package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_Ä³½½µðÆæ½º_17135_z {

	static int [][] arr ;
	static int [][] enemy;
	static int M,N;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		int count =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int n = Integer.parseInt(st.nextToken());
				arr[i][j] =n;
				if(n ==1) {count++;}
			}
		}
		enemy = new int[count][2];
		
		int index=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int n = arr[i][j];
				if(n == 1) {
					enemy[index][0] = i;
					enemy[index][1] = j;
					}
				index++;
			}
		}
		//
		
		comb(0,0);
		
		
		
		
	}
	static void comb(int start, int index) {
		if(index == 3) {
			return;
		}
		
		for(int i=start;i<M;i++) {
			comb(i+1,index+1);
		}
	}

}
