package algo_live.dp;

import java.util.Arrays;
import java.util.Scanner;

public class knapsack {

	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int W = sc.nextInt();
		arr = new int[N+1][W+1];
		

		for (int i = 1; i <= N; i++) { //각 물건
			int weights=sc.nextInt();
			int profits = sc.nextInt();

			for(int j=1; j<=W;j++) { //
				//weights가 더 무거운 경우
				if(weights > j) {
					arr[i][j] = arr[i-1][j];
				}
				else{// 이전에 넣기전까지의 최적값과, 넣은후의 최적값
					//System.out.println(arr[i-1][W-weights]);
					arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-weights]+profits);
				}

			}
			//System.out.println(Arrays.toString(arr[i]));
		}


		System.out.println(arr[N][W]);




	}

}
