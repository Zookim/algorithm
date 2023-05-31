package my.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw_NQueen_2806 {
	//N개의 퀸을 N개 놓기 위해선 조건에따라 한줄에 하나씩을 있어야한다.
	static int arr[]; //퀸은 1, 미정은 0, 불가는 2
	static int N;
	//static boolean pre[];
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =0;test_case<T;test_case++) {
			count=0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			// for문에서 각행에 놓을 위치를 정한다 -> N개 이므로 재귀이용
			// 단 지금까지 선택된 결과를 기반으로 현재위치를 결정한다.					
			put(0);		
			System.out.println(count);
		}
	}
	static void put(int index) {
		if(index == N) { // 모든행을 돌았다 -> 경우의 수가 한개 있다.
			count++;
			//System.out.println();
			return;
		}
		
		boolean [] pre = new boolean[N];
		for(int j=0;j<index;j++) { //조건검사, 현재 행에서 가능한 열을 찾는다.
			//열이 같은경우
			pre[arr[j]] = true;
			//대각선 상에 존재하는경우
			if(arr[j]+(index-j) < N) {pre[arr[j]+(index-j)] = true;}
			if(arr[j]-(index-j) >= 0) {pre[arr[j]-(index-j)] = true;}

		}
		//System.out.println(Arrays.toString(pre));
		for(int i=0;i< N;i++) {
			//단 지금까지 선택된 조건을 고려한다.
		
			if(pre[i]==false) {
				arr[index] = i; //열을 선택
				//System.out.println(i);
				put(index+1); //다음행의 열을 선택
			}
		}
	}
}
