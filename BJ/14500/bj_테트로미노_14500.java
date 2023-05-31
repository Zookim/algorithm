package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_테트로미노_14500 {

	//회전이나 대칭가능
	// 한개만 놓았을때 값이 최대가 되도록한다.
	
	// 각 도형 모양에따른 구간합을 구한다.
	static int N,M;
	static int map[][];
	static int maxs[][];
	static int sum[][];
//	static int dr[] = {-1,1,0,0};
//	static int dc[] = {0,0,-1,1};
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		maxs = new int[N][M];
		sum = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]+map[i][j];
			}
		}
		
		
		//입력 끝
		// 각 모양들에 대해 다 돌아본다 
		//findL -> 4번
		//findZ -> 4번
		//findT -> 4번
		
		// 구간 합에서 어떤 값을빼주느냐로...
		//print2();
		int max=0;
		
		int res = findLong();
		//System.out.println("long "+ res);
		int res2 = findNemo();
		//System.out.println("Nemo "+ res2);
		 max = res > res2 ? res :res2;
		//000
		//000
		int box;
		
		for(int i=2; i<= N;i++) { //행
			for(int j=3; j<= M;j++) {
				box = sum[i][j] - sum[i][j-3] - sum[i-2][j] + sum[i-2][j-3];
				int res3 = find1(box,i,j);
				max = max > res3 ? max :res3;
			}
		}
		//System.out.println("res3 "+ max);

		//00
		//00
		//00
		for(int i=3; i<= N;i++) { //행
			for(int j=2; j<= M;j++) {
				box = sum[i][j] - sum[i][j-2] - sum[i-3][j] + sum[i-3][j-2];
				int res4 = find2(box,i,j);

				max = max > res4 ? max :res4;
			}
		}
		//System.out.println("res4 "+ max);
		System.out.println(max);
		

	}
	static int find2(int box,int r,int c) {
		int res=Integer.MAX_VALUE;
		int a1 = map[r-2][c-1];
		int a2 = map[r-1][c-1];
		int a3 = map[r][c-1];
		
		int b1 = map[r-2][c];
		int b2 = map[r-1][c];
		int b3 = map[r][c];
		int resArray[]= { a1+a2,b1+b2 ,a2+a3 ,b2+b3 ,a1+a3 ,b1+b3 ,a1+b3 ,b1+a3};
		
		for(int i=0;i<8;i++) {
			res = res < resArray[i] ? res: resArray[i];
			//System.out.println("serser"+i+" "+res);
		}
		return box-res;
		
		
	}
	static int find1(int box,int r,int c) {
		int res=Integer.MAX_VALUE;
		int a1 = map[r-1][c-2];
		int a2 = map[r-1][c-1];
		int a3 = map[r-1][c];
		
		int b1 = map[r][c-2];
		int b2 = map[r][c-1];
		int b3 = map[r][c];
		int resArray[]= { a1+a2,b1+b2 ,a2+a3 ,b2+b3 ,a1+a3 ,b1+b3 ,a1+b3 ,b1+a3};
		
		for(int i=0;i<8;i++) {
			res = res < resArray[i] ? res: resArray[i];
		}
		return box-res;
		
		
	}
	static int findNemo() {
		int res=0;
		int max=0;
		
		for(int i=2; i<= N;i++) { //행
			for(int j=2; j<= M;j++) {
				res = sum[i][j] - sum[i][j-2] - sum[i-2][j] + sum[i-2][j-2];
				max = max > res ? max :res;
			}
		}
		
		
		return max;
	}
	static int findLong() {
		//세로 형으로 돌때
		int res=0;
		int max=0;
		for(int i=1; i<= M;i++) { //열
			for(int j=4; j<= N;j++) {
				res = sum[j][i] - sum[j-4][i] - sum[j][i-1] + sum[j-4][i-1];
				max = max > res ? max :res;
			}
		}
		//가로형으로 돌때 ... !
		for(int i=1; i<= N;i++) {//행
			for(int j=4; j<= M;j++) {
				res = sum[i][j] - sum[i][j-4] - sum[i-1][j] + sum[i-1][j-4];
				max = max > res ? max :res;
			}
		}
		
		return max;
	}
	
	
	
	
	static void print2() {
		for(int a[] : sum) {
			System.out.println(Arrays.toString(a));
		}
	}
	static void print() {
		for(int a[] : maxs) {
			System.out.println(Arrays.toString(a));
		}
	}

}
