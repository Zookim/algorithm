package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_가장큰정사각형_1915 {

	static int N,M;
	static int arr[][];
	static int dr[] = {0,-1,-1};//좌,상,대각
	static int dc[] = {-1,0,-1};//좌,상,대각
	public static void main(String[] args)  throws Exception  {
		

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int res=0;
		
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<M;j++) {
				int n = Integer.parseInt(str[j]);
				if(n ==1) {
					int min = Integer.MAX_VALUE;
					for(int k=0;k<3;k++) {
						int row = i +dr[k];
						int col = j +dc[k];
						int now =0;
						if(row >= 0&& row <N && col >= 0&& col <M ) {
							now =  arr[row][col];
							
						}min = min > now? now:min;
					}
					int a = n+min;
					arr[i][j] = a;
					//print();
					if(res < a) {res = a;}
					
				}else {
					arr[i][j] =0;
				}
				
				
			}
		}
		//print();
		
		System.out.println(res*res);
		
		


	}
	static void print() {
		for(int [] a: arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

}
