package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_배열돌리기4_17406 {

	static int arr[][];
	static int rcs[][];
	static int ans [][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		rcs = new int[K][3];
		ans = new int[N][M];
		int order[] = new int[K];
		int m = Integer.MAX_VALUE;

		for(int i=0;i<K;i++) {
			order[i] = i;
		}

		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			rcs[i][0] = Integer.parseInt(st.nextToken())-1;
			rcs[i][1] = Integer.parseInt(st.nextToken())-1;
			rcs[i][2] = Integer.parseInt(st.nextToken());
		}

		//입력완료

		while(true) {//한번의 순서 순열 확인
			//System.out.println(Arrays.toString(order));
			for(int i=0; i<N;i++) { //초기화 시켜준다
				for(int j=0;j<M;j++) {
					ans[i][j] = arr[i][j];
				}
			}


			for(int i=0;i < K;i++) {//각 회전 수행
				rotate(order[i]);
			}
			// 경우의 수에따라 회전 했다.

			int tsum=Integer.MAX_VALUE;   // 전체 최소값
			for(int i=0;i<N;i++) {
				int sum =0; // 각행의 합
				for(int j=0;j<M;j++) {
					sum+= ans[i][j];
				}
				if(sum < tsum) { // 해당행렬에서 최소값을 구한다.
					tsum = sum;}
			}
			m = tsum < m ? tsum : m; // 해당행렬이 최소값이 전체의 최소인지 구한다.
			if(!perm(order)) break;
		}
		System.out.println(m);
	}




	static void rotate(int i) {
		//rcs,i
		int r=rcs[i][0];
		int c=rcs[i][1];
		int s=rcs[i][2];
		int [][] an = new int [2*s+1][2*s+1];
		//값이 사라지지 않도록 복사
		int x=0,y=0;
		for(int j = r-s;j<=r+s;j++) {     
			for(int k = c-s;k<=c+s;k++) {
				an[x][y] = ans[j][k];
				y++;
			}
			y=0;
			x++;
		}

		for(int j=1;j<=s;j++) { //s만큼돈다
			for(int n=0;n<(j*2);n++) {

				ans[r-j+n][c-j] = an[s-j+n+1][s-j]; //좌
				ans[r+j-n][c+j] = an[s+j-n-1][s+j]; //우
				ans[r-j][c+j-n] =an[s-j][s+j-n-1]; //상 //
				ans[r+j][c-j+n] = an[s+j][s-j+n+1]; //하//

			}

		}
//		for(int[] a: ans) {
//			System.out.println(Arrays.toString(a));
//		}
//		System.out.println();


	}
	static boolean perm(int [] aray) {

		int i=aray.length-1;
		while(i>0 && aray[i-1] >= aray[i]) i--;
		if(i==0) return false;

		int j=aray.length-1;
		while(aray[i-1] >= aray[j]) j--;
		swap(i-1,j,aray);

		int k=aray.length-1;
		if(i<k) {
			swap(i++,k--,aray);
		}
		return true;

	}
	static void swap(int i,int j,int[] aray) {
		int temp = aray[i];
		aray[i] = aray[j];
		aray[j] = temp;
	}

}