package my.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_월드컵_6987 {

	static int arr[];
	static int res =0;
	static int select[];
	static int game[][] = {{0,0,0,0,0,1,1,1,1,2,2,2,3,3,4},{1,2,3,4,5,2,3,4,5,3,4,5,4,5,5}};

	// 00000 1111 222 33 4
	// 12345 2345 345 45 5
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int test=0;test<4;test++) {//
			arr =  new int[18];
			st = new StringTokenizer(br.readLine());
			int sum =0;
			for(int i=0;i<18;i++) {
				sum += arr[i] = Integer.parseInt(st.nextToken());
			}
			//입력 끝
			
			

			// 매 개임이 가능한 경우인지 확인한다.
			if(dfs(0) && sum ==30) {
				System.out.print("1 ");
			}else {
				System.out.print("0 ");
			}

		}
		

		
	
	}
	static boolean dfs(int n) {
		if(n==15) {
			return true; //하나라도 있으면 된다.
		}
		
		
		int teamA = game[0][n];
		int teamB = game[1][n];
		
		// 이판에서 A가 이기는 경우
		if(arr[teamA*3]>=1 && arr[teamB*3+2]>=1) {//가능한 경우라면
			arr[teamA*3]--;
			arr[teamB*3+2]--;
			//if(arr[teamA*3]>=0 && arr[teamB*3+2]>=0) return dfs(n+1);// 이렇게하면 다음경우를 확인 할 수 없다.
			if(dfs(n+1)) return true;// 참이라면 다른 것을 확인할 필요없다, false라면 다른 경로도 확인해본다.
			arr[teamA*3]++;
			arr[teamB*3+2]++;//불가능
		}
		// 이판에서 B가 이기는 경우
		if(arr[teamA*3+2]>=1 && arr[teamB*3]>=1) {//가능한 경우라면
			arr[teamA*3+2]--;
			arr[teamB*3]--;
			if(dfs(n+1)) return true;//가능하므로 다음턴으로 간다.
			arr[teamA*3+2]++;
			arr[teamB*3]++;//불가능
		}
		

		if(arr[teamA*3+1]>=1 && arr[teamB*3+1]>=1) {//가능한 경우라면
			arr[teamA*3+1]--;
			arr[teamB*3+1]--;
			if(dfs(n+1)) return true ;//가능하므로 다음턴으로 간다.
			arr[teamA*3+1]++;
			arr[teamB*3+1]++;//불가능
		}
		return false;

	}
}
