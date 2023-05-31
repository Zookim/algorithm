package my.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 시작값과 끝값에는 중복이 없어서 앞에 선택된 경우에따라 이후의 값이 바뀌는 경우가 없다.

public class sw_금속막대_1259 {

	static int N;
	static int [] dp ;
	static int [][] arr ;
	static List<List<Integer>> list = new ArrayList<>();
	//연결리스트로 변경
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr =new int[N][2];
			dp = new int[N]; //각 순서가 가질수 있는 최대값
			
			for(int i=0;i<N;i++) {
				list.add(new ArrayList<Integer>());
			}
			
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				int start =Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				arr[i][0] = start;
				arr[i][1] = end;
			}
			
			
			int res =0;
			
			int n=0;
			//List<List<Integer>> tmp = new ArrayList<>();
			for(int i=0;i<N;i++) { //모든 나사를 시작점으로 고려해보고 그중 가장 큰값을 시작점으로 해서 출력한다
				list.clear();
				int a = findLink(arr[i][0],arr[i][1],i,0); //시작점
				if(a > res) {// 이전보다 큰값이면바꾼다.
					res =a;
					n=i;
					//Collections.copy(tmp, list);
	
				}	


			}
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append("#").append(test_case).append(" ");

			
			for(int a : list.get(n)) {
				sb2.append(arr[a][0]).append(" ").append(arr[a][1]).append(" ");
			}
			
			
			System.out.println(sb2);
			
			
			
		}
		
		

	}
	
	static int findLink(int start, int end,int n,int pre) {
		
		
		
		if(dp[n] > 0) { // 이전에 확인한 값이라면
		
			return dp[n];
		}
		
		//확인하지 않은 값이라면 다음 값으로 가서 확인한다.
		for(int j=0; j<N;j++) {
			if(arr[j][0] == arr[n][1]) { //시작과 다음끝이 같다면
				int a = findLink(arr[n][1], arr[j][0],j,n);
				list.get(n).addAll(list.get(j));
				return dp[n]= a +1;
			}
		}
		// 연결되는것이 없다면, 기저 
		list.get(n).add(n);
		return dp[n] = 1;
			
	}

}
