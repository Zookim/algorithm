package my.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw_NQueen_2806_x {
	// 이렇게 풀면 모든 경우를 고려할 수 없다.
	// 첫째 것을 정하고 둘째 것을 정할때 둘째것이 가능한경우가 2가지 이상일수 있고
	// 이경우를 고려하지 않았다.
	static int arr[][]; //퀸은 1, 미정은 0, 불가는 2
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =0;test_case<T;test_case++) {
			N = Integer.parseInt(br.readLine());
			
			
			int res =0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.println(i+"  "+j);
					arr = new  int [N][N];//초기화 필요
					res += put(i,j);
					
				}
			}
			System.out.println(res);

		}

	}
	static int put(int startr,int startc) {
		int count=0;
		int res=0;
		
		//시작점 이후로 시작해야한다
		check(startr,startc);
		arr[startr][startc] =1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(arr[i][j] == 0) { // 미정인 곳만 후보로 둔다.
					check(i,j);
					arr[i][j] = 1;
					count++; //사용된 퀸의수
					//
					for(int [] a : arr) {
						System.out.println(Arrays.toString(a));
					}
					System.out.println();
					//
				}
			}
		}
		if(count == N) {res=1;}
		return res;
	}
	static void check(int r,int c) { //현재 퀸을기준으로 이후 배열 중 갈수없는 곳을 지정한다.
		int index=0;
		int index2=0;
		for(int i=r;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1) {;}
				if(i == r ||j == c ) {arr[i][j] = 2;} // 행이나 열이 같으면 모두 지운다.
				
				if(i ==(r+index2) && j ==(c+index2)) {index2++;arr[i][j]=2; } //과거는 고려하지 않는다.오른쪽
				if(i ==(r+index) && j ==(c-index)) {index++;arr[i][j]=2; } //과거는 고려하지 않는다.왼쪽
			}
		}
		
	}

}
