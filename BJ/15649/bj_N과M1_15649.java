package my.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_N과M1_15649 {

	static int N,M;
	static boolean select[];
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		select = new boolean[N+1];
		arr = new int[N];
		perm(0);
		
//		for(int i=1;i<=N;i++) {
//			arr[i-1] = i;
//		}
//		
//		while(true) {
//			
//			for(int a: arr) {
//				sb.append(a).append(" ");
//			}
//			System.out.println(sb);
//			sb.setLength(0);
//			if(!np(arr)) break;
//		}
		
		
		

	}
	//1.재귀
	static void perm(int index) {
		if(index == M) {
			System.out.println(sb);
			
			return;}
		
		for(int i=1;i<=N;i++) {
			if(select[i]) continue;
			select[i] =true;
			sb.append(i).append(" ");
			perm(index+1);
			sb.setLength(sb.length()-2);
			select[i] = false;
		}
		
	}
//	//2. NP(단 N개를 N길이로 정렬할때만가능 뽑아 쓰지 못한다.)
//	//ex 13542 -> 14532 ->14523
//	static boolean np(int[] input) {
//		int i=input.length-1;
//		while(i>=0 && input[i-1] >= input[i]) {i--;} //꼭지 앞을 찾아서
//		if(i ==0) return false;
//		
//		int j = input.length-1;
//		while(input[j] <= input[i-1]) {j--;} //꼭지점 앞의 값보다 큰값을 찾아서
//		swap(i-1,j);
//		
//		int k = input.length-1;
//		while(i<k) {swap(i++,k--);}
//		//k==i거나, i가 더 뒤쪽에 있므면 정렬이 필요하지 않은 경우이다 (그럴일은 없지만)
//		return true;
//	}
//	static void swap(int a,int b) {
//		int tmp = arr[a];
//		arr[a] = arr[b];
//		arr[b] = tmp;
//	}
//	

}
